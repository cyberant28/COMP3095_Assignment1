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
         * user can create a recipe //done
         * get recipes by user
         * user can add a recipe to favourite //done for one recipe
         * search all recipe in system by created date
         * user can add a meal //done
         * user can add recipes to that meal
         * get all meals for user
         * get all meals for user within certain date range
         */
        User user1 = new User("Ryan Murphy", "12345");

        Recipe recipe1 = new Recipe("Jam pudding", user1);

        PlannedMeal meal1 = new PlannedMeal("My first meal", user1);



        userService.save(user1);

        recipeService.save(recipe1);

        mealService.save(meal1);

        System.out.println(userService.findAll());
        System.out.println(recipeService.findAll());
        System.out.println(mealService.findAll());

        userService.addFavouriteRecipeToUser(user1, recipe1);





    }
}
