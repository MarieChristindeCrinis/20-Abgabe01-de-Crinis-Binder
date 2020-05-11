package at.fhj.iit;

/**
 * If no alcohol is found in the ingredients list this exception should be thrown.
 *
 */
public class AlcoholNotFoundException extends Exception  {

    private String weakMindedCocktailName;

    public AlcoholNotFoundException(String name) {
        weakMindedCocktailName = name;
    }

    @Override
    public String getMessage() {
        return weakMindedCocktailName+" is not a proper cocktail due to the lack of alcohol.";
    }
}
