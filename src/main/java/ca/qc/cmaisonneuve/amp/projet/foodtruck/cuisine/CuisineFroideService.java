
package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;

/**
 * Implémentation de CuisineService représentant une station froide,
 * c'est-à-dire une mini-cuisine qui ne peut qu'assembler des plats froids (pas
 * de four ou autres éléments chauffants). Dans le food truck, on pourrait par
 * exemple imaginer un petit comptoir sur le côté où on assemble uniquement les
 * plats ne demandant aucune cuisson (ingrédients froids seulement), permettant
 * ainsi de libérer de l'espace dans la cuisine principale et de traiter plus de
 * commandes en parallèle.
 */
public class CuisineFroideService implements AssemblageService {

    @Override
    public boolean assembler(String itemType) {
        System.out.println("Cuisine froide: plat %s assemble".formatted(itemType));
        return true;
    }

    @Override
    public boolean garderAuFrais(String itemType) {
        System.out.println("Cuisine froide: plat %s mis dans une glaciere".formatted(itemType));
        return true;
    }

    @Override
    public boolean ajouterExtras(String itemType, Map<FoodOptionType, String> options) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuisine froide: ajout d'extras pour le plat ").append(itemType).append(": ");
        options.forEach((key, value) -> sb.append(key.name().toLowerCase()).append(" (").append(value).append("), "));
        if (!options.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        System.out.println(sb.toString());
        return true;
    }
}
