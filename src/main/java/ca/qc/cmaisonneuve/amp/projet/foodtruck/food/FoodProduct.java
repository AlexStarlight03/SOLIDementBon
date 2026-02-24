package ca.qc.cmaisonneuve.amp.projet.foodtruck.food;

import java.util.List;
import java.util.Map;

public interface FoodProduct {
    String getType();
    List<FoodOption> getAvailableOptions();
    double calculerPrix(Map<FoodOptionType, String> options);
}
