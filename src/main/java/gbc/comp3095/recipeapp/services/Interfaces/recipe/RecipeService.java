package gbc.comp3095.recipeapp.services.Interfaces.recipe;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface RecipeService extends CrudService<Recipe, Long> {
    void updateRecipeTitleDirections(Long id, String newTitle, String newDirections);
}
