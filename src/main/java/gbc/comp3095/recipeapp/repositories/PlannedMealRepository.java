package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import org.springframework.data.repository.CrudRepository;

public interface PlannedMealRepository extends CrudRepository<PlannedMeal, Long> {
}
