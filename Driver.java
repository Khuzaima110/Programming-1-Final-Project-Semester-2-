import java.util.Scanner;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args) {
        RecipeBook myBook = new RecipeBook();

        // Pre-fill with one recipe so choice 1 actually shows something![cite: 1]
        Recipe r1 = new Recipe("Pasta", 2, RecipeTag.DAIRY_FREE);
        r1.addIngredient(new Ingredient("Noodles", 200, "g"));
        myBook.addRecipe(r1);

        
        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println("Welcome to the Recipe Book");

        while (choice !=0){
            System.out.println("\n1. List all recipes");
            System.out.println("2. Search by tag");
            System.out.println("3. Rate a recipe");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
            if(choice==1) {
                myBook.listAll();
            } else if (choice == 2){
                System.out.println("Select a tag: 1. DAIRY_FREE, 2. VEGAN, 3. GLUTEN_FREE");
                int tagChoice = input.nextInt();
                input.nextLine();
                RecipeTag selectedTag=null;
                if (tagChoice == 1) 
                {
                    selectedTag = RecipeTag.DAIRY_FREE;
                }
                else if (tagChoice == 2) {
                    selectedTag = RecipeTag.VEGAN;
                }
                else if (tagChoice == 3) {
                    selectedTag = RecipeTag.GLUTEN_FREE;
                }

                if (selectedTag != null) {
                    myBook.searchByTag(selectedTag);
                }
            } else if (choice == 3){
                System.out.print("Enter the title of the recipe to rate: ");
                String title = input.nextLine();

                // This part assumes you add a findByTitle method to your RecipeBook
                Recipe found = myBook.findByTitle(title); 

                if (found != null) {
                    System.out.print("Enter rating (1-5): ");
                    int rate = input.nextInt();
                    input.nextLine();
                    found.setRating(rate); // Calls your rating validation logic!
                } else {
                    System.out.println("Recipe not found.");
                }

            } else if(choice==0){

            }

        }
        System.out.println("Goodbye");
    }
}