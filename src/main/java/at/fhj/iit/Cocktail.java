package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;

public class Cocktail extends Drink{

    private List<Liquid> ingredients;

    /**
     * Creates a Drink object with given name
     *
     * @param name name of the drink
     */
    public Cocktail(String name) {
        super(name);
        this.ingredients = new ArrayList<>();
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getAlcoholPercent() {
        return 0;
    }

    @Override
    public boolean isAlcoholic() {
        return false;
    }

    /**
     * Adds a liquid to the ingredients list
     * @param l the liquid that should be added
     */
    public void addIngredient(Liquid l) {
        this.ingredients.add(l);
    }

    /**
     * Removes a liquid from the list of ingredients
     * @param l the liquid to be removed
     */
    public void removeIngredient(Liquid l) {
        this.ingredients.remove(l);
    }

    /**
     * Removes a liquid from the list of ingredients at a given index
     * @param index the position of the ingredient to be removed
     */
    public void removeIngredient(int index) {
        this.ingredients.remove(index);
    }

    /**
     * Returns the recipe for this cocktail 
     * @return the recipe for the cocktail
     */
    public String recipe() {

    }
}
