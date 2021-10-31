package gbc.comp3095.recipeapp.services;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    PlannedMeal savePlannedMeal(PlannedMeal meal);
    Recipe saveRecipe(Recipe recipe);

    void addRecipeToFavourites(String username, String title);
    User getUser(String username);
    List<User> getUsers();


}
