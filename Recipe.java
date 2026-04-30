import java.util.ArrayList;

/**
 * Write a description of class Recipe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recipe
{
    private String title;
    private int servings;
    private ArrayList<Ingredient> ingredients;
    private RecipeTag tag;
    private double rating;

    public Recipe(String title, int servings, RecipeTag tag)
    {
        this.title = title;
        this.servings=servings;
        this.tag=tag;
        this.ingredients= new ArrayList<>(); //making an ArrayList

    }

    public void addIngredient(Ingredient ingredient)
    {
        this.ingredients.add(ingredient);
    }

    public void scale(int newServings)
    {
        // 1. Calculate the factor (use double to keep decimals)
        double factor = (double) newServings / this.servings;

        // 2. Loop through your association (the ArrayList of ingredients)
        for (Ingredient i : ingredients) {
            // 3. Get the current quantity, multiply it, and set the new one
            double updatedQuantity = i.getQuantity() * factor;
            i.setQuantity(updatedQuantity);
        }

        // 4. Update the recipe's servings to the new value
        this.servings = newServings; 
    }

    public String toString()
    {
        String details = "Title: " + title + "\nTag: " + tag + "\nIngredients:\n";
        for (Ingredient i : ingredients) {
            details += "- " + i.toString() + "\n";
        }
        return details;
    }

    public RecipeTag getTag() {
        return this.tag;
    }
}