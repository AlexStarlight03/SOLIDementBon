package ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement;

public class CartePaymentType implements PaymentType {
    @Override
    public void payer(double prix) {
        System.out.println("Paiement par carte de %.2f$ effectué.".formatted(prix));
    }

    
}
