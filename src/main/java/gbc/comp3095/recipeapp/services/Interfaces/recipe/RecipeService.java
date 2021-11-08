/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Interface for recipe service includes update method defintion
 *********************************************************************************/
package gbc.comp3095.recipeapp.services.Interfaces.recipe;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface RecipeService extends CrudService<Recipe, Long> {
    void updateRecipeTitleDirections(Long id, String newTitle, String newDirections);
}
