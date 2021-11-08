/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Repo for meals
 *********************************************************************************/
package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import org.springframework.data.repository.CrudRepository;

public interface PlannedMealRepository extends CrudRepository<PlannedMeal, Long> {
}
