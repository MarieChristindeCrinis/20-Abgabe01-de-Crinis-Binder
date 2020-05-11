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
        return this.ingredients
                .stream()
                .map(x -> x.getVolume())
                .reduce(0.0, Double::sum);
    }

    @Override
    public double getAlcoholPercent() {
        return this.ingredients
                .stream()
                .map(x -> x.getAlcoholPercent())
                .max(Double::compareTo)
                .orElse(0.0);
    }

    @Override
    public boolean isAlcoholic() {
        return this.ingredients
                .stream()
                .anyMatch(x -> x.getAlcoholPercent() > 0);
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
     * Returns the count of ingredients
     * @return the count of ingredients
     */
    public int getIngredientCount(){
        return this.ingredients.size();
    }

    /**
     * Returns the recipe for this cocktail 
     * @return the recipe for the cocktail
     */
    public String recipe() throws AlcoholNotFoundException{

        String str = "";
        boolean alcoholic = false;
        for(Liquid c : ingredients){
            if(c.getAlcoholPercent()> 0) {
                alcoholic = true;
            }
            str += String.format("%-8s | %.0f ml\n" , c.getName(), c.getVolume()*100);
        }
        if(!alcoholic) {
            throw new AlcoholNotFoundException(this.name);
        }
        return str;
    }
}
