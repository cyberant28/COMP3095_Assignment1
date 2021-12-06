package gbc.comp3095.recipeapp.services.Interfaces.user;

import gbc.comp3095.recipeapp.models.Item;
import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface UserService extends CrudService<User, Long> {

    public Meal createMeal(User user, Meal meal);

    public Recipe createRecipe(User user, Recipe recipe);

    public Item addI(User user, Item item);

    void addFavouriteRecipe(User user, Recipe recipe);

    void removeFavouriteRecipe(User user, Recipe recipe);

    void createUser(User user);

    void addShoppingListItem(User user, Item item);

}
