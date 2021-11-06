package gbc.comp3095.recipeapp.services.Implementations;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.meal.PlannedMealServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbstractDataAccessService {

    private final PlannedMealServiceImpl plannedMealService;
    private final UserServiceImpl userService;
    private final RecipeServiceImpl recipeService;

    @Autowired
    public AbstractDataAccessService(PlannedMealServiceImpl plannedMealService, UserServiceImpl userService, RecipeServiceImpl recipeService) {
        this.plannedMealService = plannedMealService;
        this.userService = userService;
        this.recipeService = recipeService;
    }

    //TODO: why does saving recipe here auto increment id?
    public void createRecipe(User user, Recipe recipe){
        recipe.setRecipeAuthor(user);
        recipeService.save(recipe);
        userService.save(user);
        userService.createNewRecipe(user, recipe);


    }
}
