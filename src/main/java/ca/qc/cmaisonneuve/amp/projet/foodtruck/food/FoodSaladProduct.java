package ca.qc.cmaisonneuve.amp.projet.foodtruck.food;

import java.util.List;
import java.util.Map;

public class FoodSaladProduct implements FoodProduct {
    @Override
    public String getType() {
        return "SALADE";
    }

    @Override
    public List<FoodOption> getAvailableOptions() {
        return List.of(
            new FoodOption(FoodOptionType.TAILLE, "Taille", "PETITE", "GRANDE"),
            new FoodOption(FoodOptionType.VINAIGRETTE, "Vinaigrette", "CESAR", "MAISON"),
            new FoodOption(FoodOptionType.EXTRA_FROMAGE, "Extra fromage", "OUI", "NON"),
            new FoodOption(FoodOptionType.EPICE, "Épicé", "OUI", "NON")
        );
    }

    @Override
    public double calculerPrix(Map<FoodOptionType, String> options) {
        double prix = 6.0;
        if ("GRANDE".equalsIgnoreCase(options.getOrDefault(FoodOptionType.TAILLE, "PETITE"))) {
            prix += 2.0;
        }
        if ("CESAR".equalsIgnoreCase(options.getOrDefault(FoodOptionType.VINAIGRETTE, "MAISON"))) {
            prix += 0.5;
        }
        if ("OUI".equalsIgnoreCase(options.getOrDefault(FoodOptionType.EXTRA_FROMAGE, "NON"))) {
            prix += 0.5;
        }
        if ("OUI".equalsIgnoreCase(options.getOrDefault(FoodOptionType.EPICE, "NON"))) {
            prix += 0.5;
        }
        return prix;
    }
}
