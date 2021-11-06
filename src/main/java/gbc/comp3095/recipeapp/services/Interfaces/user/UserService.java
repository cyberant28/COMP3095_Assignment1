package gbc.comp3095.recipeapp.services.Interfaces.user;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface UserService extends CrudService<User, Long> {

    public void addFavouriteRecipeToUser(User user, Recipe recipe);
    public void createNewRecipe(User user, Recipe recipe);
}
