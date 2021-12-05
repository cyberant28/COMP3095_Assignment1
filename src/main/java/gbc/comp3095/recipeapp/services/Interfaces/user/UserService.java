package gbc.comp3095.recipeapp.services.Interfaces.user;

import gbc.comp3095.recipeapp.models.*;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface UserService extends CrudService<User, Long> {

    public Meal createMeal(User user, Meal meal);

    Event createEvent(User user, Event event);

    public Recipe createRecipe(User user, Recipe recipe);

    void addFavouriteRecipe(User user, Recipe recipe);

    void removeFavouriteRecipe(User user, Recipe recipe);

    void createUser(User user);

    void addShoppingListItem(User user, Item item);
}
