package ca.qc.cmaisonneuve.amp.projet.foodtruck.cuisine;

public interface CuissonService {
    boolean cuire(String itemType);
    boolean garderAuChaud(String itemType);
}
