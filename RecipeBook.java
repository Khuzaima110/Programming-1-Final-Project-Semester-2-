import java.util.ArrayList;

/**
 *This class here is responsible for actually having the recipeies. 
 *All these are not done directly, the Driver class is doing it while you put in
 *what you want
 *  */
public class RecipeBook
{
    private ArrayList<Recipe> recipes;
    /**creating the ArrayList
     * 
     */
    public RecipeBook()
    {
        this.recipes= new ArrayList<>(); 
    }
    /**adding recipes (Not done directly, done via the driver class)
     * 
     */
    public void addRecipe(Recipe recipe)
    {
        this.recipes.add(recipe);

    }
    /**finds the recipees by name
     * 
     */
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
    /**searches recipies by tags, not name
     * 
     */
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
    /**lists all recipes currently in the recipe book
     * 
     */
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
    /**prints top rated recipe
     * 
     */
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
    /**prints the details about the recipe book
     * 
     */
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