import java.util.ArrayList;


/**
 * These are the recipes 
 */
public class Recipe
{
    private String title;
    private int servings;
    private ArrayList<Ingredient> ingredients;
    private RecipeTag tag;
    private double rating;
    
    //
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
    
    public double getRating()
    {
        return rating;
    }
    
    public void setRating(double rating)
    {
        this.rating=rating;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title=title;
    }
    
    public int getServings()
    {
        return servings;
    }
    
    public void rate(int newRating)
    {
        //makes sure rating is from 1 to 5
        if(newRating>=1 && newRating<= 5)
        {
            this.rating = newRating;
            System.out.println("Successfully rated "+ newRating+" stars.");
        } else{
            System.out.println("Invalid rating. Please enter a value from 1 to 5");
        }
    }
}