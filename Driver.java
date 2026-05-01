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

        DrinkRecipe mojito = new DrinkRecipe("Mojito", 1, RecipeTag.VEGAN, true);
        mojito.addIngredient(new Ingredient("Lime juice", 30, "ml"));
        mojito.addIngredient(new Ingredient("White Rum", 50, "ml"));
        mojito.addIngredient(new Ingredient("Sugar", 2, "tsp"));
        myBook.addRecipe(mojito);

        DrinkRecipe orangeJuice = new DrinkRecipe("Orange juice", 3, RecipeTag.GLUTEN_FREE, false);
        orangeJuice.addIngredient(new Ingredient("Orange", 175, "g"));
        orangeJuice.addIngredient(new Ingredient("Sugar", 4, "g"));
        myBook.addRecipe(orangeJuice);

        Scanner input = new Scanner(System.in);
        int choice = -1;
        System.out.println("Welcome to the Recipe Book");

        while (choice !=0){
            System.out.println("\n1. List all recipes");
            System.out.println("2. Search by tag");
            System.out.println("3. Rate a recipe");
            System.out.println("4. Scale recipe");
            System.out.println("5. Find highest rated");
            System.out.println("6. Print book details");
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

            } else if(choice==4){
                System.out.print("Enter the title of the recipe to scale: ");
                String title = input.nextLine();
                Recipe found = myBook.findByTitle(title);

                if (found != null) {
                    System.out.print("How many servings do you want now? ");
                    int servings = input.nextInt();
                    input.nextLine();
                    found.scale(servings);
                    System.out.println("Recipe scaled successfully!");
                } else {
                    System.out.println("Recipe not found.");
                }
            } else if(choice == 5){
                myBook.printTopRated();
            } else if(choice == 6)
            {
                myBook.printBookDetails();
            }else if(choice == 7){
                System.out.println("--- Create a New Recipe ---");

                //getting the info
                System.out.print("Enter Title: ");
                String title = input.nextLine();

                System.out.print("Enter Servings: ");
                int servings = input.nextInt();
                input.nextLine();

                System.out.println("Select Tag: 1. DAIRY_FREE, 2. VEGAN, 3. GLUTEN_FREE");
                int tagChoice = input.nextInt();
                input.nextLine();
                RecipeTag tag = (tagChoice == 1) ? RecipeTag.DAIRY_FREE : (tagChoice == 2) ? RecipeTag.VEGAN : RecipeTag.GLUTEN_FREE;
                
                //now we creat user's recipe
                
            }

        }
        System.out.println("Goodbye");
    }
}