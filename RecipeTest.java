
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeTest
{
    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
    {
        
    }
    
    @Test
    public void testScaling()
    {
        //creating a recipe with 2 servings and 100 g of sugar
        Recipe r = new Recipe("Cake", 2, RecipeTag.VEGAN);
        Ingredient sugar = new Ingredient ("Sugar", 100.0, "g");
        r.addIngredient(sugar);

        //gonna scale it to 4 sevings
        r.scale(4);

        //gonna check if the quantity is now 200.0
        //also the 0.1 is basically the tolerates here
        assertEquals(200.0, sugar.getQuantity(), 0.1);
        assertEquals(4, r.getServings());

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
     
    }
}