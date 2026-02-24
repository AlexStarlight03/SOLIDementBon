package ca.qc.cmaisonneuve.amp.projet.foodtruck.notification;

public class NotificationFactory {
    public static NotificationService getNotificationService(String itemType) {
        return switch (itemType.toUpperCase()) {
            case "EMAIL" -> new NotificationEmailService();
            case "SMS" -> new NotificationSMSService();
            default -> throw new IllegalArgumentException("Type de notification inconnu: " + itemType);
        };
    }
    
}
