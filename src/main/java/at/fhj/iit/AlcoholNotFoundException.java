package at.fhj.iit;

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
