/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: repo for recipe
 *********************************************************************************/
package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findByTitleContainingIgnoreCase(String searchQuery);
}
