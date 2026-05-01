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

    public Recipe findByTitle(String title)
    {
        for(Recipe r: recipes){
            //use equalsIgnoreCase so Pasta matches pasta
            if(r.getTitle().equalsIgnoreCase(title)){
                return r; //found it, so send the object back
            }
        }
        return null; //Looked but didn't find it
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
        if(recipes.isEmpty()){
            System.out.println("The recipe book is empty");
        } else{
            for(Recipe r : recipes) {
                System.out.println(r.toString());
                System.out.println("--------------------");
            }
        }
    }

    public void printTopRated()
    {
        if (recipes.isEmpty()) {
            System.out.println("The book is empty");
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

    public void printBookDetails() {
        System.out.println("--- Recipe Book Statistics ---");
        System.out.println("Total Number of Recipes: " + recipes.size());

        int totalServings = 0;
        for (Recipe r : recipes) {
            totalServings += r.getServings();
        }
        System.out.println("Total servings available in book: " + totalServings);
    }
}