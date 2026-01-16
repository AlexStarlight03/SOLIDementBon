
package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

/**
 * Implémentation de CuisineService représentant une station froide,
 * c'est-à-dire une mini-cuisine qui ne peut qu'assembler des plats froids (pas
 * de four ou autres éléments chauffants). Dans le food truck, on pourrait par
 * exemple imaginer un petit comptoir sur le côté où on assemble uniquement les
 * plats ne demandant aucune cuisson (ingrédients froids seulement), permettant
 * ainsi de libérer de l'espace dans la cuisine principale et de traiter plus de
 * commandes en parallèle.
 */
public class CuisineFroideService implements CuisineService {

    @Override
    public boolean cuire(String itemType) {
        throw new UnsupportedOperationException(
                "Cuisine froide: Impossible de cuire le plat %s: grill non disponible!".formatted(itemType));
    }

    @Override
    public boolean assembler(String itemType) {
        System.out
                .println("Cuisine froide: plat %s assemble".formatted(itemType));
        return true;
    }

    @Override
    public boolean garderAuFrais(String itemType) {
        System.out.println("Cuisine froide: plat %s mis dans une glaciere".formatted(itemType));
        return true;
    }

    @Override
    public boolean garderAuChaud(String itemType) {
        throw new UnsupportedOperationException(
                "Cuisine froide: Impossible de garder le plat %s au chaud: rechaud non disponible!"
                        .formatted(itemType));
    }

    @Override
    public boolean ajouterExtras(String itemType, boolean extraFromage, boolean epice) {
        System.out.println("Cuisine froide: ajout d'extras pour le plat %s: epice (%s), fromage (%s)"
                .formatted(itemType, epice ? "o" : "n", extraFromage ? "o" : "n"));
        return true;
    }
}
