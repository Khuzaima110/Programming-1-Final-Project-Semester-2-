import java.util.ArrayList;

/**
 * Write a description of class RecipeBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecipeBook
{
    private ArrayList<Recipe> recipes;

    public RecipeBook()
    {
        this.recipes= new ArrayList<>(); 
    }

    public void addRecipe(Recipe recipe)
    {
        this.recipes.add(recipe);

    }

    public void searchByTag(RecipeTag tag)
    {
        System.out.println("Searching for: " + tag);
        boolean found = false;
        for(Recipe r:recipes){
            if(r.getTag()== tag){
                System.out.println(r.toString());
                found = true;
            }
        }
        if(!found)
        {
            System.out.println("No recipes found with that tag.");
        }
    }

    public void listAll()
    {

    }

    public void printTopRated()
    {
        if (recipes.isEmpty()) {
            System.out.println("No recipes to rate.");
            return;
        }

        Recipe highest = recipes.get(0); // Start with the first one

        for (Recipe r : recipes) {
            if (r.getRating() > highest.getRating()) {
                highest = r; // Found a new winner
            }
        }

        System.out.println("The top-rated recipe is: " + highest.getTitle());
    }
}