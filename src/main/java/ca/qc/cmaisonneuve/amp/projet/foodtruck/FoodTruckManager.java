
package ca.qc.cmaisonneuve.amp.projet.foodtruck;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine.AssemblageService;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine.CuisineFactory;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine.CuissonService;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodProduct;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.notification.NotificationFactory;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.notification.NotificationService;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement.PaymentType;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.persistence.Persistence;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.persistence.SqlDatabasePersistence;
/**
 * Gestionnaire du Food Truck SOLIDEMENT Bon
 */
public class FoodTruckManager {

    private final Persistence database = new SqlDatabasePersistence();
    private final NotificationService notificationService;

    public FoodTruckManager(String notificationType) {
        this.notificationService = NotificationFactory.getNotificationService(notificationType);
    }

    public void traiterCommande(String email, FoodProduct produit, Map<FoodOptionType, String> selectedOptions, PaymentType paiement) {
        double prix = produit.calculerPrix(selectedOptions);
        paiement.payer(prix);
        database.sauvegarderCommande(email, produit.getType(), prix, selectedOptions);
        notificationService.envoyerNotification(email, "SOLIDEMENT Bon - Confirmation de commande",
                "Votre commande de %s est en preparation.".formatted(produit.getType()), produit.getType(), prix);
        // Envoi en cuisine
        String status = preparerPlat(produit, selectedOptions);
        notificationService.envoyerNotification(email, "SOLIDEMENT Bon - Commande prête",
                "Votre commande de %s est prête!".formatted(produit.getType()), produit.getType(), prix);
        System.out.println("[Journal] Commande " + status);
    }

    // Préparation d'une commande en cuisine
    private String preparerPlat(FoodProduct produit, Map<FoodOptionType, String> selectedOptions) {
        Object cuisine = CuisineFactory.getCuisine(produit.getType());
        boolean success = true;

        if (cuisine instanceof CuissonService cuisson) {
            success &= cuisson.cuire(produit.getType());
            success &= cuisson.garderAuChaud(produit.getType());
        }
        if (cuisine instanceof AssemblageService assemblage) {
            success &= assemblage.assembler(produit.getType());
            success &= assemblage.ajouterExtras(produit.getType(), selectedOptions);
            success &= assemblage.garderAuFrais(produit.getType());
        }
        return success ? "prete" : "annulee";
    }
}
