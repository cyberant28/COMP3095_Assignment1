package gbc.comp3095.recipeapp.bootstrap;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.repositories.UserRepository;
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

        User user1 = new User("Ryan", "Murphy", "12345");
        Recipe recipe1 = new Recipe("Pizza");
        PlannedMeal meal1 = new PlannedMeal("Monday lunch");

        user1.getRecipes().add(recipe1);
        user1.getPlannedmeals().add(meal1);

        userRepository.save(user1);
        recipeRepository.save(recipe1);
        plannedMealRepository.save(meal1);



        System.out.println(user1.getRecipes());
        System.out.println("User ID: " + user1.getId());
        System.out.println(user1.getPlannedmeals());
        System.out.println(recipe1.getId());
        System.out.println(meal1.getTitle());

        System.out.println("Number of recipes " + recipeRepository.count());


    }
}
