package ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement;

public class ComptantPaymentType implements PaymentType {
    @Override
    public void payer(double prix) {
        System.out.println("Paiement de %.2f$ en comptant effectué.".formatted(prix));
    }
}
