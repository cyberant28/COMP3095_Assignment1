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


        User user1 = new User("Ryan Murphy", "12345");


        Recipe recipe1 = new Recipe("Jam pudding");

        Recipe recipe2 = new Recipe("Toast Sandwich");

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        PlannedMeal meal1 = new PlannedMeal("My first meal", today);


        userService.save(user1);
        userService.createRecipe(user1, recipe1);
        userService.createRecipe(user1, recipe2);
        userService.createMeal(user1, meal1);
        mealService.addRecipe(meal1, recipe1);
        userService.addFavouriteRecipe(user1, recipe2);










    }
}
