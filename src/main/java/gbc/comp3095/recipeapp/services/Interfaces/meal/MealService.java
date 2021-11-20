/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Interface for meal service extends CRUDSERVICE then includes additional methods
 *********************************************************************************/
package gbc.comp3095.recipeapp.services.Interfaces.meal;

import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface MealService extends CrudService<Meal, Long> {

    Recipe addRecipe(Meal meal, Recipe recipe);

    void updateMealTitle(Long id, String newTitle);
}
