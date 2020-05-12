# 20-Abgabe01-de-Crinis-Binder

## Description
This project is used to practice the use of GitHub and Unit Tests.
To reach this goal, we used the project Drink to practice.

In order to learn how to use GitHub and Unit Tests, we decided to
extend the class *Drink* with the class *Cocktails*.

In the class *Cocktails*, we create a List of Ingredients
that a Cocktail is made of.

To learn how to work with Unit Tests, we create the
test class *CocktailTest* to fill the Ingredient List.

## Special Code

For the *Cocktails* class we used the recipe method:
```
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
```

In Testing we used a setup mehtod in order to have all the ingredients in one central
place.
```
    @BeforeEach
    void setup() {
        // SETUP PHASE
        alcohol = new Liquid("Rum", 0.04, 80);
        softdrink = new Liquid("Cola", 0.2, 0);
        iceCream = new Liquid("Softeis", 0.3, 0);
    }
```
Note that we use a *@BeforeEach* Annotation in order to execute the *setup()* method
before executing each test.
