package gbc.comp3095.recipeapp.services.Implementations.user;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
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
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;

        this.recipeRepository = recipeRepository;
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


    @Override
    public void addFavouriteRecipeToUser(User user, Recipe recipe) {
        Optional<Recipe> searchRecipe = recipeRepository.findById(recipe.getId());
        Recipe foundRecipe = searchRecipe.get();

        user.getFavouriteRecipes().add(foundRecipe);
        recipe.getFavouritedBy().add(user);

        recipe.setFavouritedBy(
                recipe.getFavouritedBy()
        );
        userRepository.save(user);
        recipeRepository.save(recipe);
    }

    @Override
    public void createNewRecipe(User user, Recipe recipe) {
        Optional<Recipe> searchRecipe = recipeRepository.findById(recipe.getId());
        Recipe foundRecipe = searchRecipe.get();

        user.getCreatedRecipes().add(foundRecipe);
        foundRecipe.setRecipeAuthor(user);

        recipeRepository.save(foundRecipe);
        userRepository.save(user);

    }
}
