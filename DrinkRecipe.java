
/**
 * Write a description of class drinkRecipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrinkRecipe extends Recipe
{
    private boolean isAlcoholic;
    public DrinkRecipe(String title, int servings, RecipeTag tag, boolean isAlcoholic)
    {
        super(title, servings, tag);
        this.isAlcoholic= isAlcoholic;
    }
    
    @Override
    public String toString()
    {
        String type = isAlcoholic? "Alcoholic" :"Non Alcoholic";
        return super.toString()  + "\nType: " +type;
    }
}