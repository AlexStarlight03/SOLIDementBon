package ca.qc.cmaisonneuve.amp.projet.foodtruck.notification;

public class NotificationSMSService implements NotificationService {
    @Override
    public void envoyerNotification(String destinataire, String sujet, String corpsTexte, String typeCommande, double montant){
        String messageId = "MSG-" + System.currentTimeMillis();
        System.out.println("Envoi du SMS à " + destinataire + " : " + sujet + "\n" + corpsTexte);
        System.out.println(formatting(destinataire, sujet, corpsTexte, destinataire, montant, messageId));
        System.out.println("[Journal] SMS envoye a " + destinataire + " avec Message-ID " + messageId + ".");
    }

    @Override
    public String formatting(String destinataire,
            String sujet,
            String corpsTexte,
            String typeCommande,
            double montant,
            String messageId) {
        String LINE_SEPARATOR = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("[SOLIDement Bon]").append(LINE_SEPARATOR);
        sb.append("Commande: ").append(typeCommande != null ? typeCommande : "(inconnu)");
        sb.append(" | Montant: ").append(String.format(java.util.Locale.CANADA_FRENCH, "%.2f$", montant)).append(LINE_SEPARATOR);
        sb.append("Client: ").append(destinataire != null ? destinataire : "(inconnu)").append(LINE_SEPARATOR);
        if (sujet != null && !sujet.isEmpty()) {
            sb.append("Sujet: ").append(sujet).append(LINE_SEPARATOR);
        }
        sb.append("Msg: ").append(corpsTexte != null ? corpsTexte : "(aucun contenu)").append(LINE_SEPARATOR);
        sb.append("ID: ").append(messageId);
        return sb.toString();
    }
    
}
