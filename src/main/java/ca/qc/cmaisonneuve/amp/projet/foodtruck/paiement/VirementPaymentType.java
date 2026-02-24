package ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement;

public class VirementPaymentType implements PaymentType {
    @Override
    public void payer(double prix) {
        System.out.println("Paiement de %.2f par virement bancaire.".formatted(prix));
    }
    
}
