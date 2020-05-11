package at.fhj.iit;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@DisplayName("Testing Cocktail implementation")
public class CocktailTest {

    private Liquid alcohol, softdrink, iceCream;

    /**
     * inits an alcoholic and nonalcoholic liquid for EACH test
     */
    @BeforeEach
    void setup() {
        // SETUP PHASE
        alcohol = new Liquid("Rum", 0.04, 80);
        softdrink = new Liquid("Cola", 0.2, 0);
        iceCream = new Liquid("Softeis", 0.3, 0);
    }

    /**
     * tests the cocktail for correct constructor
     */
    @Test
    @DisplayName("Testing constructor")
    public void testConstructorCocktail(){

        Cocktail cocktail = new Cocktail("Rum-Cola");

        assertEquals("Rum-Cola", cocktail.name);
    }

    /**
     * adds ingredients and checks if the method has the expected format
     */
    @Test
    @DisplayName("Testing recipe method with two ingredients")
    public void testRecipeMethod(){

        Cocktail cocktail = new Cocktail("Rum-Cola");
        cocktail.addIngredient(alcohol);
        cocktail.addIngredient(softdrink);
        String expected = "Rum      | 4 ml\nCola     | 20 ml\n";
        String result = "";
        try{
            result = cocktail.recipe();
        } catch(AlcoholNotFoundException ex) {
            assert(false);
        }
        assertEquals(expected, result);
    }

    /**
     * tests if the exception for non-alcoholic cocktails and the message of it, works properly.
     */
    @Test
    @DisplayName("Testing recipe method with no alcohol")
    public void testRecipeMethodExpectException(){

        Cocktail cocktail = new Cocktail("Taube-Nüsschen Becher");
        cocktail.addIngredient(iceCream);
        String expected = "Taube-Nüsschen Becher is not a proper cocktail due to the lack of alcohol.";
        try {
            cocktail.recipe();
            assert(false);
        } catch(AlcoholNotFoundException ex) {
            assertEquals(expected, ex.getMessage());
        }

    }

    /**
     * tests the adding and removing of ingredients and checks format
     */
    @Test
    @DisplayName("Testing adding and removing of ingredients")
    public void testAddAndRemoveIngredient(){

        Cocktail cocktail = new Cocktail("Rum-Cola");
        cocktail.addIngredient(alcohol);
        cocktail.addIngredient(softdrink);
        assertEquals(2, cocktail.getIngredientCount());
        cocktail.removeIngredient(alcohol);
        assertEquals(1, cocktail.getIngredientCount());
        cocktail.removeIngredient(0);
        assertEquals(0,cocktail.getIngredientCount());
    }

    /**
     * tests if the cocktail is alcoholic
     */
    @Test
    @DisplayName("Testing is alcoholic cocktail")
    public void testIsAlcoholicMethod() {

        Cocktail cocktail = new Cocktail("Rum-Cola");
        cocktail.addIngredient(alcohol);

        assertEquals(true, cocktail.isAlcoholic());

        cocktail.removeIngredient(alcohol);

        assertEquals(false, cocktail.isAlcoholic());

        cocktail.addIngredient(softdrink);

        assertEquals(false, cocktail.isAlcoholic());
    }

    /**
     * tests the alcohol percentage of alcoholic cocktail
     */
    @Test
    @DisplayName("Testing get alcohol percent")
    public void testGetAlcoholPercent() {

        Cocktail cocktail = new Cocktail("Rum-Cola");
        cocktail.addIngredient(alcohol);

        assertEquals(alcohol.getAlcoholPercent(), cocktail.getAlcoholPercent());

        cocktail.removeIngredient(alcohol);

        assertEquals(0, cocktail.getAlcoholPercent());

        cocktail.addIngredient(softdrink);

        assertEquals(0, cocktail.getAlcoholPercent());
    }

    /**
     * tests if the volume of the cocktail is the same as the sum of the ingredients
     */
    @Test
    @DisplayName("Testing get volume")
    public void testGetVolume() {
        Cocktail cocktail = new Cocktail("Rum-Cola");
        cocktail.addIngredient(alcohol);

        assertEquals(alcohol.getVolume(), cocktail.getVolume());

        cocktail.addIngredient(softdrink);

        assertEquals(alcohol.getVolume() + softdrink.getVolume(), cocktail.getVolume());
    }
}

