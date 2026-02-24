
package ca.qc.cmaisonneuve.amp.projet.foodtruck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOption;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodProduct;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodProductFactory;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.menu.Menu;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement.PaymentType;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement.PaymentTypeFactory;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.validation.ValidationService;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();
        ValidationService validationService = new ValidationService();

        System.out.println("=== SOLIDEMENT Bon - Commandes CLI ===");

        boolean running = true;
        while (running) {
            String itemType = menu.demanderTypePlat();
            if ("QUIT".equals(itemType)) break;
            String typeNotification = menu.demanderTypeNotification();
            String contact;
            if ("EMAIL".equalsIgnoreCase(typeNotification)) {
                contact = menu.demanderEmail();
                if (!validationService.isValidEmail(contact)) {
                    menu.afficherMessage("Adresse courriel invalide. Veuillez réessayer.");
                    continue;
                }
            } else if ("SMS".equalsIgnoreCase(typeNotification)) {
                contact = menu.demanderTel();

            } else {
                menu.afficherMessage("Type de notification inconnu. Veuillez réessayer.");
                continue;
            }
            try {
                FoodProduct produit = FoodProductFactory.create(itemType);
                List<FoodOption> options = produit.getAvailableOptions();
                Map<FoodOptionType, String> selectedOptions = new HashMap<>();
                for (FoodOption option : options) {
                    String value = menu.demanderOption(option.getLabel(), option.getValeursPossibles());
                    selectedOptions.put(option.getType(), value);
                }
                String typePaiement = menu.demanderTypePaiement();


                PaymentType paiement = PaymentTypeFactory.create(typePaiement);
                FoodTruckManager manager = new FoodTruckManager(typeNotification);
                manager.traiterCommande(contact, produit, selectedOptions, paiement);
                menu.afficherMessage("Commande traitee.");
            } catch (Exception e) {
                menu.afficherMessage(e.getMessage());
            }
            running = menu.demanderOuiNon("Voulez-vous passer une autre commande ?");
        }

        System.out.println("Au revoir !");
    }
}
