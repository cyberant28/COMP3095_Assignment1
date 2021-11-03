package gbc.comp3095.recipeapp.services.user;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final PlannedMealRepository plannedMealRepository;

    public UserServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository, PlannedMealRepository plannedMealRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.plannedMealRepository = plannedMealRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public PlannedMeal savePlannedMeal(PlannedMeal meal) {
        return plannedMealRepository.save(meal);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void addRecipeToFavourites(long userId, long recipeId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();

        Optional<Recipe> optionalRecipe = recipeRepository.findById(recipeId);
        Recipe recipe = optionalRecipe.get();

        user.getFavouritedRecipes().add(recipe);

        userRepository.save(user);




    }

    @Override
    public User getUser(long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getUsers() {
        List<User> allUsers = (List<User>) userRepository.findAll();

        return allUsers;
    }
}
