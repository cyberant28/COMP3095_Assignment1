package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
