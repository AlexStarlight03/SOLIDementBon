package ca.qc.cmaisonneuve.amp.projet.foodtruck.persistence;

import java.util.Map;

import ca.qc.cmaisonneuve.amp.projet.foodtruck.food.FoodOptionType;

/**
 * Classe représentant un objet qui s'occupe de communiquer avec une base de
 * données SQL pour faire la sauvegarde des commandes
 */
public class SqlDatabasePersistence implements Persistence {

    @Override
    public void sauvegarderCommande(String contact,
            String type,
            double prix,
            Map<FoodOptionType, String> options) {
        StringBuilder sb = new StringBuilder();
        options.forEach((key, value) -> sb.append(key.name().toLowerCase()).append(" (").append(value).append("), "));
        System.out.println("Commande sauvegardee pour " + contact + " : " + type + sb + " -> " + prix);
    }
}
