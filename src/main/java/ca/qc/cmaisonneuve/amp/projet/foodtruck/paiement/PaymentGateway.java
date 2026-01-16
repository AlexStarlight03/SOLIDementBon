
package ca.qc.cmaisonneuve.amp.projet.foodtruck.paiement;

/**
 * Passerelle de paiement, qui permet de payer en utilisant divers modes de paiement.
 */
public class PaymentGateway {

    public void payerCarte(double montant) {
        System.out.println("Carte facturee: " + montant);
    }

    public void payerComptant(double montant) {
        System.out.println("Argent comptant recu: " + montant);
    }

    public void echec(String raison) {
        System.out.println("Le paiement a echoue: " + raison);
    }
}
