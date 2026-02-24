package ca.qc.cmaisonneuve.amp.projet.foodtruck.food;

public class FoodOption {
    private final FoodOptionType type;
    private final String label;
    private final String[] valeursPossibles;

    public FoodOption(FoodOptionType type, String label, String... valeursPossibles) {
        this.type = type;
        this.label = label;
        this.valeursPossibles = valeursPossibles;
    }

    public FoodOptionType getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public String[] getValeursPossibles() {
        return valeursPossibles;
    }
}
