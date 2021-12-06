package gbc.comp3095.recipeapp.services.Interfaces.shoppingList;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.ShoppingList;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface ShoppingListService extends CrudService<Recipe, Long> {

    public ShoppingList createShoppingList(ShoppingList shoppingList);

}
