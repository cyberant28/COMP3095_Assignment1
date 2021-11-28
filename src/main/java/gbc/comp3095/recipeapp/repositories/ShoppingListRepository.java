package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<Recipe, Long> {
}
