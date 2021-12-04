/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen , Saad Khan >
 * Student Number: < 101378456 , 101157307 >
 * Date: 07-11-2021
 * Description: Loads default data for the application
 *********************************************************************************/

package gbc.comp3095.recipeapp.bootstrap;

import gbc.comp3095.recipeapp.models.*;
import gbc.comp3095.recipeapp.services.Implementations.meal.MealServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.shoppingList.ShoppingListServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class StartUp implements CommandLineRunner {

    private UserServiceImpl userService;
    private RecipeServiceImpl recipeService;
    private MealServiceImpl mealService;
    private ShoppingListServiceImpl shoppingListService;

    @Autowired
    public StartUp(UserServiceImpl userService, RecipeServiceImpl recipeService, MealServiceImpl mealService, ShoppingListServiceImpl shoppingListService) {
        this.userService = userService;
        this.recipeService = recipeService;
        this.mealService = mealService;
        this.shoppingListService = shoppingListService;
    }

    public void generateRecipes(User user, int numRecipes){

        //TODO: add more adjectives, items, garnishes
        String [] adjectives = {"Orange" , "Pink" , "Seared" , "Toasted" , "Sauted", "Peeled", "Boiled", "Aged"};
        String [] items = {"Chicken", "Tea", "Cake", "Salmon", "Beef", "Ceviche", "Mink", "Curry" , "Quesadilla"};
        String [] garnishes = {"BBQ Sauce", "Icing Sugar" , "Chives", "Oregano", "Pink Salk" , "Nutritional Yeast" , "Maple Syrup" , "Gravy"};

        for(int i=0; i<numRecipes; i++){
            String recipeName = "";
            recipeName += adjectives[(int) Math.floor(Math.random()* adjectives.length)] +" ";
            recipeName += items[(int) Math.floor(Math.random()* items.length)] +" with ";
            recipeName += garnishes[(int) Math.floor(Math.random()* garnishes.length)];
            Recipe recipe = new Recipe(recipeName);
            recipe.setDescription("Make me a " + recipeName +" please");
            userService.createRecipe(user, recipe);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * TODO: use cases to test
         * search all recipe in system by created date
         * get all meals for user within certain date range
         */

        User user1 = new User("Ryan Murphy", "12345");
        User userJ = new User("James Bond", "5432");
        User userM = new User("Marlon Brando", "password");
        User userN = new User("Nasrit Khan", "password");
        User userO = new User("Ophelia Diaz", "password");
        User userP = new User("Petro Peu", "password");

        Recipe recipe1 = new Recipe("Jam pudding");

        recipe1.getIngredients().add(new Ingredient("Jam", recipe1));
        recipe1.getIngredients().add(new Ingredient("Pudding", recipe1));
        recipe1.setDescription("make me a jam pudding please");

        Recipe recipe2 = new Recipe("Toast Sandwich");
        recipe2.setDescription("Make me a Toast pease");

        Recipe recipeJ = new Recipe("Slime Stew");
        recipeJ.setDescription("make me a Slime Stew please");

        Recipe recipeM = new Recipe("Kashmiri Chai");
        recipeM.getIngredients().add(new Ingredient("milk", recipeM));
        recipeJ.setDescription("make me a Kashmiri Chai please");

        Recipe recipeN = new Recipe("Orange Lemonade");
        recipeJ.setDescription("make me a Orange Lemonade please");

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        Meal meal1 = new Meal("My first meal", today);
        Meal meal2 = new Meal("My second meal", today);
        Meal meal3 = new Meal("My third meal", today);





        userService.createUser(user1);
        userService.createUser(userJ);
        userService.createUser(userM);
        userService.createUser(userN);
        userService.createUser(userO);

        userService.createRecipe(user1, recipe1);
        userService.createRecipe(user1, recipe2);
        userService.createRecipe(userJ, recipeJ);
        userService.createRecipe(userM, recipeM);

        generateRecipes(user1, 6);
        generateRecipes(userJ, 4);
        generateRecipes(userM, 10);
        generateRecipes(userN, 12);
        generateRecipes(userO, 2);

        userService.createRecipe(userM, recipeN);
        userService.createMeal(user1, meal1);
        userService.createMeal(user1, meal2);
        userService.createMeal(user1, meal3);

        mealService.addRecipe(meal1, recipe1);
        userService.addFavouriteRecipe(user1, recipe2);

        shoppingListService.createShoppingList( new ShoppingList("my shopping list"));
        Item item = new Item("Sugar", 23.4);
        Item item2 = new Item("Coffee", 4334.4);

        Item item3 = new Item("Milk", 734.1);
        userService.addShoppingListItem(user1, item);
        userService.addShoppingListItem(user1, item2);

        userService.addShoppingListItem(user1, item3);

















    }
}
