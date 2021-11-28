package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
}
