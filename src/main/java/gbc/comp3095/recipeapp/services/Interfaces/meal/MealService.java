package gbc.comp3095.recipeapp.services.Interfaces.meal;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface MealService extends CrudService<PlannedMeal, Long> {
    Recipe addRecipe(PlannedMeal meal, Recipe recipe);
}
