package gbc.comp3095.recipeapp.services.Implementations.user;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.repositories.UserRepository;
import gbc.comp3095.recipeapp.services.Interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final PlannedMealRepository mealRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository, PlannedMealRepository mealRepository) {
        this.userRepository = userRepository;

        this.recipeRepository = recipeRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public Optional<User> find(User object) {

        return userRepository.findById(object.getId());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User object) {
        userRepository.save(object);
        return object;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

        Optional<User> user  = userRepository.findById(id);
        userRepository.delete(user.get());
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);

    }
    //TODO: is this really necessary?
    private Recipe findRecipe(Recipe recipe){
        Optional<Recipe> searchRecipe = recipeRepository.findById(recipe.getId());
        Recipe foundRecipe = searchRecipe.get();
        return foundRecipe;
    }


    @Override
    public void createMeal(User user, PlannedMeal meal) {
        meal.setMealAuthor(user);
        user.getPlannedMeals().add(meal);
        mealRepository.save(meal);
        userRepository.save(user);

    }

    @Override
    public Recipe createRecipe(User user, Recipe recipe) {
        recipe.setRecipeAuthor(user);

        user.getCreatedRecipes().add(recipe);
        recipe.setRecipeAuthor(user);

        recipeRepository.save(recipe);
        userRepository.save(user);

        return recipe;
    }


    @Override
    public void addFavouriteRecipe(User user, Recipe recipe) {

        Recipe foundRecipe = findRecipe(recipe);

        user.getFavouriteRecipes().add(foundRecipe);
        recipe.getFavouritedBy().add(user);

        recipe.setFavouritedBy(
                recipe.getFavouritedBy()
        );
        userRepository.save(user);
        recipeRepository.save(recipe);
    }
}
