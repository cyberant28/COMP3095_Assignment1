package gbc.comp3095.recipeapp.services.Interfaces.item;

import gbc.comp3095.recipeapp.models.Ingredient;
import gbc.comp3095.recipeapp.models.Item;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.Step;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

import java.util.Set;


public interface ItemService extends CrudService<Item, Long> {
    void updateItemNamePrice(Long id, String newName, double newPrice);

}
