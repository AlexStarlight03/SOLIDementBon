
package ca.qc.cmaisonneuve.amp.projet.foodtruck;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine.CuisineCompleteService;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine.CuisineFroideService;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement.PaymentGateway;
import ca.qc.cmaisonneuve.amp.projet.foodtruck.persistence.SqlDatabasePersistence;

/**
 * Gestionnaire du Food Truck SOLIDEMENT Bon
 */
public class FoodTruckManager {

    /** Constante qui définit le caractère de saut de ligne */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private PaymentGateway paymentGateway = new PaymentGateway();
    private SqlDatabasePersistence database = new SqlDatabasePersistence();

    private CuisineCompleteService cuisine = new CuisineCompleteService();
    private CuisineFroideService comptoirFroid = new CuisineFroideService();

    public void traiterCommande(String email, String type, boolean extraFromage, boolean epice, String modePaiement) {

        // Calcul du prix
        double prix = 0.0;
        if ("BURGER".equals(type)) {
            prix = 8.0;
            if (extraFromage) {
                prix = prix + 1.0;
            }
            if (epice) {
                prix = prix + 0.5;
            }
        } else if ("TACO".equals(type)) {
            prix = 7.0;
            if (extraFromage) {
                prix = prix + 0.5;
            }
            if (epice) {
                prix = prix + 0.5;
            }
        } else if ("WRAP".equals(type)) {
            prix = 6.5;
            if (extraFromage) {
                prix = prix + 0.8;
            }
        } else {
            System.out.println("Type de plat inconnu: " + type);
        }

        // Paiement
        if ("CARTE".equals(modePaiement)) {
            paymentGateway.payerCarte(prix);
        } else if ("COMPTANT".equals(modePaiement)) {
            paymentGateway.payerComptant(prix);
        } else {
            paymentGateway.echec("Mode de paiement non pris en charge");
        }

        // Sauvegarde de la commande en base de données
        database.sauvegarderCommande(email, type, prix, extraFromage, epice);

        // Envoi de la notification au client - seulement par courriel pour l'instant...
        envoyerCourriel(email, "SOLIDEMENT Bon - Confirmation de commande",
                "Votre commande de %s est en preparation.".formatted(type), type, prix);

        // Envoi en cuisine
        String status = prepare(type, epice, extraFromage);
        System.out.println("[Journal] Commande " + status);
    }

    // Préparation d'une commande en cuisine
    private String prepare(String itemType, boolean epice, boolean extraFromage) {
        return switch (itemType) {
            case "BURGER" -> prepareBurger(epice, extraFromage);
            case "TACO" -> prepareTaco(epice, extraFromage);
            case "WRAP" -> prepareWrap(epice, extraFromage);
            default -> "annulee";
        };
    }

    private String prepareBurger(boolean epice, boolean extraFromage) {
        boolean success = cuisine.cuire("BURGER")
                && cuisine.assembler("BURGER")
                && cuisine.ajouterExtras("BURGER", extraFromage, epice)
                && cuisine.garderAuChaud("BURGER");

        return "%s (burger %s%s)".formatted(success ? "prete" : "annulee", epice ? "epice" : "regulier",
                extraFromage ? " extra fromage" : "");
    }

    private String prepareTaco(boolean epice, boolean extraFromage) {
        boolean success = cuisine.cuire("TACO")
                && cuisine.assembler("TACO")
                && cuisine.ajouterExtras("TACO", extraFromage, epice)
                && cuisine.garderAuChaud("TACO");
        return "%s (taco %s%s)".formatted(success ? "prete" : "annulee", epice ? "epice" : "regulier",
                extraFromage ? " extra fromage" : "");
    }

    private String prepareWrap(boolean epice, boolean extraFromage) {
        boolean success = comptoirFroid.assembler("WRAP")
                && comptoirFroid.ajouterExtras("WRAP", extraFromage, epice)
                && comptoirFroid.garderAuFrais("WRAP");
        return "%s (wrap %s%s)".formatted(success ? "prete" : "annulee", epice ? "epice" : "regulier",
                extraFromage ? " extra fromage" : "");
    }

    // Formattage et envoi d'un courriel de confirmation au client
    private void envoyerCourriel(String destinataire,
            String sujet,
            String corpsTexte,
            String typeCommande,
            double montant) {
        // Génération d'un identifiant de message "factice"
        String messageId = "MSG-" + System.currentTimeMillis();

        // Formattage de base d'un courriel
        String separateur = "--------------------------------------------------";
        StringBuilder sb = new StringBuilder();
        sb.append(LINE_SEPARATOR).append(separateur).append(LINE_SEPARATOR);
        sb.append("SOLIDement Bon - Notification de commande").append(LINE_SEPARATOR);
        sb.append("Message-ID : ").append(messageId).append(LINE_SEPARATOR);
        sb.append("A          : ").append(destinataire != null ? destinataire : "(inconnu)").append(LINE_SEPARATOR);
        sb.append("Sujet      : ").append(sujet != null ? sujet : "(sans sujet)").append(LINE_SEPARATOR);
        sb.append(separateur).append(LINE_SEPARATOR);
        sb.append("Resume de la commande").append(LINE_SEPARATOR);
        sb.append(" - Type : ").append(typeCommande != null ? typeCommande : "(inconnu)").append(LINE_SEPARATOR);
        sb.append(" - Montant : ").append(String.format(java.util.Locale.CANADA_FRENCH, "%.2f $", montant))
                .append(LINE_SEPARATOR);
        sb.append(separateur).append(LINE_SEPARATOR);
        sb.append("Message :").append(LINE_SEPARATOR);
        sb.append(corpsTexte != null ? corpsTexte : "(aucun contenu)").append(LINE_SEPARATOR);
        sb.append(separateur).append(LINE_SEPARATOR);
        sb.append("Courriel envoye. ").append(LINE_SEPARATOR);

        // "Envoi" (simulation) : écriture dans la console
        System.out.println(sb.toString());
        System.out.println("[Journal] Courriel envoye a " + destinataire + " avec Message-ID " + messageId + ".");
    }

}
