package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;

public interface AssemblageService {
    boolean assembler(String itemType);
    boolean ajouterExtras(String itemType, Map<FoodOptionType, String> options);
    boolean garderAuFrais(String itemType);
}
