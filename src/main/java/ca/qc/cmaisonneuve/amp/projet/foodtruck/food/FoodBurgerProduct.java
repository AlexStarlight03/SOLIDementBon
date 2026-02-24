package ca.qc.cmaisonneuve.amp.projet.foodtruck.food;

import java.util.List;
import java.util.Map;

public class FoodBurgerProduct implements FoodProduct {
    @Override
    public String getType() {
        return "BURGER";
    }

    @Override
    public List<FoodOption> getAvailableOptions() {
        return List.of(
            new FoodOption(FoodOptionType.EXTRA_FROMAGE, "Extra fromage", "OUI", "NON"),
            new FoodOption(FoodOptionType.EPICE, "Épicé", "OUI", "NON")
        );
    }

    @Override
    public double calculerPrix(Map<FoodOptionType, String> options) {
        double prix = 8.0;
        if ("OUI".equalsIgnoreCase(options.getOrDefault(FoodOptionType.EXTRA_FROMAGE, "NON"))) {
            prix += 1.0;
        }
        if ("OUI".equalsIgnoreCase(options.getOrDefault(FoodOptionType.EPICE, "NON"))) {
            prix += 0.5;
        }
        return prix;
    }
}
