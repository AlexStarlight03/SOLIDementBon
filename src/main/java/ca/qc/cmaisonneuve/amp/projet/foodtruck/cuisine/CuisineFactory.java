package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

public class CuisineFactory {
    public static Object getCuisine(String itemType) {
        return switch (itemType.toUpperCase()) {
            case "BURGER", "TACO" -> new CuisineCompleteService();
            case "WRAP", "SALADE" -> new CuisineFroideService();
            default -> throw new IllegalArgumentException("Type de plat inconnu: " + itemType);
        };
    }
}
