package ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement;

public class PaymentTypeFactory {
        public static PaymentType create(String type) {
        return switch (type.toUpperCase()) {
            case "COMPTANT" -> new ComptantPaymentType();
            case "CARTE" -> new CartePaymentType();
            case "VIREMENT" -> new VirementPaymentType();
            default -> throw new IllegalArgumentException("Type de paiement " + type + " inconnu");
        };
    }
    
}
