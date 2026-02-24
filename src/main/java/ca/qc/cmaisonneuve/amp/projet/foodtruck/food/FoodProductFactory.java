package ca.qc.cmaisonneuve.amp.projet.foodtruck.food;

public class FoodProductFactory {
    public static FoodProduct create(String type) {
        return switch (type.toUpperCase()) {
            case "BURGER" -> new FoodBurgerProduct();
            case "TACO" -> new FoodTacoProduct();
            case "WRAP" -> new FoodWrapProduct();
            case "SALADE" -> new FoodSaladProduct();
            default -> throw new IllegalArgumentException("Type de plat inconnu: " + type);
        };
    }
}
