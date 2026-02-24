package ca.qc.cmaisonneuve.amp.projet.foodtruck.notification;

public interface NotificationService {
    void envoyerNotification(String destinataire, String sujet, String corpsTexte, String typeCommande, double montant);
    String formatting(String destinataire, String sujet, String corpsTexte, String typeCommande, double montant, String messageId);
}
