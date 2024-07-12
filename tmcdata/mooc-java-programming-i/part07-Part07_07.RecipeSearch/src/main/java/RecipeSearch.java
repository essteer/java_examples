import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File to read: ");
        String file = scanner.nextLine();
        ArrayList<Recipe> cookbook = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get(file))) {

            while (reader.hasNextLine()) {

                String title = reader.nextLine();
                int cookingTime = Integer.valueOf(reader.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();

                while (reader.hasNextLine()) {
                    String ingredient = reader.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }
                    ingredients.add(ingredient);
                }
                Recipe recipe = new Recipe(title, cookingTime, ingredients);
                cookbook.add(recipe);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Reading the file " + file + " failed.");
        }

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {

            System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : cookbook) {
                    System.out.println(recipe.toString());
                }
            } else if (command.equals("find name")) {
                System.out.println("");
                System.out.print("Searched word: ");
                String term = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : cookbook) {
                    if (recipe.getName().contains(term)) {
                        System.out.println(recipe.toString());
                    }
                }
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int time = Integer.valueOf(scanner.nextLine());
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : cookbook) {
                    if (recipe.getTime() <= time) {
                        System.out.println(recipe.toString());
                    }
                }
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String term = scanner.nextLine();
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : cookbook) {
                    ArrayList<String> ingredients = recipe.getIngredients();
                    for (String item : ingredients) {
                        if (item.equals(term)) {
                            System.out.println(recipe.toString());
                        }
                    }
                }
            }
        }
        scanner.close();
    }

}
