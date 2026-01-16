
package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

/**
 * Interface rassemblant toutes les opérations pouvant être faites en cuisine.
 * 
 * Chaque méthode représente une action pouvant être faite en cuisine. L'idée
 * est que, pour chaque plat, on appelle uniquement les méthodes requises pour
 * préparer ce plat en cuisine.
 * 
 * Il est possible qu'une implémentation ne permette pas toutes les opérations,
 * par exemple si une cuisine n'a pas tous les équipements requis pour effectuer
 * une étape. Les méthodes correspondant à des étapes qui ne sont pas prises en
 * charge doivent retourner "false"
 */
public interface CuisineService {

    /**
     * Faire cuire le plat.
     * 
     * @param itemType le type de plat.
     */
    boolean cuire(String itemType);

    /**
     * Assembler les ingrédients du plat.
     * 
     * @param itemType le type de plat.
     */
    boolean assembler(String itemType);

    /**
     * Ajouter les extras / options choisis par le client
     * 
     * @param itemType     type de plat
     * @param extraFromage extra fromage ?
     * @param epice        extra piquant ?
     */
    boolean ajouterExtras(String itemType, boolean extraFromage, boolean epice);

    /**
     * Garder le plat au frais une fois qu'il a été préparé.
     * 
     * @param itemType type de plat
     */
    boolean garderAuFrais(String itemType);

    /**
     * Garder le plat au chaud une fois qu'il a été préparé.
     * 
     * @param itemType type de plat
     */
    boolean garderAuChaud(String itemType);
}
