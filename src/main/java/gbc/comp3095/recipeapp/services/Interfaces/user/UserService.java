package gbc.comp3095.recipeapp.services.Interfaces.user;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface UserService extends CrudService<User, Long> {

    void createMeal(User user, PlannedMeal meal);

    public Recipe createRecipe(User user, Recipe recipe);

    void addFavouriteRecipe(User user, Recipe recipe);

    void createUser(User user);
}
