package ca.qc.cmaisonneuve.amp.projet.foodtruck.persistence;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;

public interface Persistence {
    public void sauvegarderCommande(String email,
            String type,
            double prix,
            Map<FoodOptionType, String> options
        );
}
