
package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;

/**
 * Implémentation de CuisineService qui représente une cuisine complète,
 * c'est-à-dire une cuisine où fours, friteuses et autres éléments chauffants
 * sont disponibles. On peut y préparer les plats chauds ou les plats froids.
 * Dans le food truck, cette cuisine correspondrait à l'espace de cuisine
 * principal à l'intérieur.
 */
public class CuisineCompleteService implements CuissonService, AssemblageService {

    @Override
    public boolean cuire(String itemType) {
        System.out.println("Cuisine: plat %s cuit".formatted(itemType));
        return true;
    }

    @Override
    public boolean assembler(String itemType) {
        System.out.println("Cuisine: plat %s assemble".formatted(itemType));
        return true;
    }

    @Override
    public boolean garderAuFrais(String itemType) {
        System.out.println("Cuisine: plat %s mis au refrigerateur".formatted(itemType));
        return true;
    }

    @Override
    public boolean garderAuChaud(String itemType) {
        System.out.println("Cuisine: plat %s mis sur le rechaud".formatted(itemType));
        return true;
    }

    @Override
    public boolean ajouterExtras(String itemType, Map<FoodOptionType, String> options) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuisine : ajout d'extras pour le plat ").append(itemType).append(": ");
        options.forEach((key, value) -> sb.append(key.name().toLowerCase()).append(" (").append(value).append("), "));
        if (!options.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        System.out.println(sb.toString());
        return true;
    }
}
