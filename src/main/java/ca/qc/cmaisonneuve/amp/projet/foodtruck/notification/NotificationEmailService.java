package ca.qc.cmaisonneuve.amp.projet.foodtruck.notification;

public class NotificationEmailService implements NotificationService {
    @Override
    public void envoyerNotification(String destinataire, String sujet, String corpsTexte, String typeCommande, double montant){
        String messageId = "MSG-" + System.currentTimeMillis();
        System.out.println("Envoi du courriel à " + destinataire + " : " + sujet + "\n" + corpsTexte);
        System.out.println(formatting(destinataire, sujet, corpsTexte, destinataire, montant, messageId));
        System.out.println("[Journal] Courriel envoye a " + destinataire + " avec Message-ID " + messageId + ".");
    }

    @Override
    public String formatting(String destinataire,
            String sujet,
            String corpsTexte,
            String typeCommande,
            double montant,
            String messageId) {
        String LINE_SEPARATOR = System.lineSeparator();
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
        return sb.toString();
    }
}
