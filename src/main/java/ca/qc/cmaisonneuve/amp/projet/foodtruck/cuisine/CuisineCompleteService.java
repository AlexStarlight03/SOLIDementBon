
package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

/**
 * Implémentation de CuisineService qui représente une cuisine complète,
 * c'est-à-dire une cuisine où fours, friteuses et autres éléments chauffants
 * sont disponibles. On peut y préparer les plats chauds ou les plats froids.
 * Dans le food truck, cette cuisine correspondrait à l'espace de cuisine
 * principal à l'intérieur.
 */
public class CuisineCompleteService implements CuisineService {

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
    public boolean ajouterExtras(String itemType, boolean extraFromage, boolean epice) {
        System.out.println("Cuisine: ajout d'extras pour le plat %s: epice (%s), fromage (%s)".formatted(itemType,
                epice ? "o" : "n", extraFromage ? "o" : "n"));
        return true;
    }
}
