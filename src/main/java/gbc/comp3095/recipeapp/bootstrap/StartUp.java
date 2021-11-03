package gbc.comp3095.recipeapp.bootstrap;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.repositories.UserRepository;
import gbc.comp3095.recipeapp.services.user.UserService;
import gbc.comp3095.recipeapp.services.user.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {

    private UserRepository userRepository;
    private RecipeRepository recipeRepository;
    private PlannedMealRepository plannedMealRepository;

    public StartUp(UserRepository userRepository, RecipeRepository recipeRepository, PlannedMealRepository plannedMealRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.plannedMealRepository = plannedMealRepository;
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
        User user2 = new User("Lex Luthor", "010110");

        Recipe recipe1 = new Recipe("Pizza", user1);
        Recipe recipe2 = new Recipe("Sushi", user1);
        Recipe recipe3 = new Recipe("Soup", user2);
        PlannedMeal meal1 = new PlannedMeal("Monday lunch", user1);

        meal1.getRecipes().add(recipe1);



        user1.getRecipes().add(recipe1);
        user1.getRecipes().add(recipe2);

        user2.getRecipes().add(recipe3);

        user1.getPlannedMeals().add(meal1);

        user1.getFavouritedRecipes().add(recipe1);
        recipe1.getFavouritedBy().add(user1);





        UserService userService = new UserServiceImpl(userRepository, recipeRepository, plannedMealRepository);
        userService.saveUser(user1);
        userRepository.save(user2);
        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);

        recipeRepository.save(recipe3);
        plannedMealRepository.save(meal1);


       // userService.addRecipeToFavourites(user1.getId(), recipe3.getId());








        System.out.println(user1.getRecipes());
        System.out.println(user2.getRecipes());
        System.out.println("User ID: " + user1.getId());
        System.out.println(user1.getPlannedMeals());
        System.out.println(recipe1.getId());
        System.out.println(meal1.getTitle());
        System.out.println(recipe1.getFavouritedBy());



    }
}
