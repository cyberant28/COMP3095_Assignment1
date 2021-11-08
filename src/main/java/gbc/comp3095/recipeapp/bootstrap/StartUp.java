/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen >
 * Student Number: < 101378456 >
 * Date: 07-11-2021
 * Description: the StartUP class create dummy data for our application
 *********************************************************************************/
package gbc.comp3095.recipeapp.bootstrap;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.meal.PlannedMealServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
public class StartUp implements CommandLineRunner {

    private UserServiceImpl userService;
    private RecipeServiceImpl recipeService;
    private PlannedMealServiceImpl mealService;


    @Autowired
    public StartUp(UserServiceImpl userService, RecipeServiceImpl recipeService, PlannedMealServiceImpl mealService) {
        this.userService = userService;
        this.recipeService = recipeService;
        this.mealService = mealService;
    }


    @Override
    public void run(String... args) throws Exception {
        /**
         * TODO: use cases to test
         * search all recipe in system by created date
         * get all meals for user within certain date range
         */

        //userCreation
        User user1 = new User("Ryan-Murphy", "12345");
        User user2 = new User("Tom-Wayne", "12345");
        User user3 = new User("Henry-Adams", "12345");
        User user4 = new User("Allen-Punk", "12345");

        //recipeCreation
        Recipe recipe1 = new Recipe("Jam pudding");
        recipe1.setDirections("make me a jam pudding please");

        Recipe recipe2 = new Recipe("Toast Sandwich");
        recipe2.setDirections("Make me a Toast pease");

        Recipe recipe3 = new Recipe("Pizza margarita");
        recipe2.setDirections("Make me a Pizza margarita");

        Recipe recipe4 = new Recipe("Pasta bolognese");
        recipe2.setDirections("Make me a Pasta bolognese");

        Recipe recipe5 = new Recipe("Tuna salad");
        recipe2.setDirections("Make me a Tuna salad");

        Recipe recipe6 = new Recipe("Potato salad");
        recipe2.setDirections("Make me a Potato Potato");

        //plannedMealCreation
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        PlannedMeal meal1 = new PlannedMeal("My first meal", today);
        PlannedMeal meal2 = new PlannedMeal("My second meal", today);
        PlannedMeal meal3 = new PlannedMeal("My third meal", today);



        //user 1
        userService.save(user1);
        userService.createRecipe(user1, recipe1);
        userService.createRecipe(user1, recipe2);
        userService.createMeal(user1, meal1);
        mealService.addRecipe(meal1, recipe1);
        userService.addFavouriteRecipe(user1, recipe2);

        //user 2
        userService.save(user2);
        userService.createRecipe(user2, recipe3);
        userService.createRecipe(user2, recipe4);
        userService.createMeal(user2, meal2);
        mealService.addRecipe(meal2, recipe4);

        //user 3
        userService.save(user3);
        userService.createRecipe(user3, recipe5);
        userService.createRecipe(user3, recipe6);
        userService.createMeal(user3, meal3);
        mealService.addRecipe(meal3, recipe5);

        //user 4
        userService.save(user4);















    }
}
