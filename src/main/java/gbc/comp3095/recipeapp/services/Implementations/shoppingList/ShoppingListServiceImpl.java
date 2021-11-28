package gbc.comp3095.recipeapp.services.Implementations.shoppingList;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.ShoppingList;
import gbc.comp3095.recipeapp.repositories.ShoppingListRepository;
import gbc.comp3095.recipeapp.services.Interfaces.shoppingList.ShoppingListService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    ShoppingListRepository shoppingListRepository;

    public ShoppingListServiceImpl(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Recipe> find(Recipe object) {
        return Optional.empty();
    }

    @Override
    public Recipe save(Recipe object) {
        return null;
    }

    @Override
    public Iterable<Recipe> findAll() {
        return null;
    }

    @Override
    public void delete(Recipe object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public ShoppingList createShoppingList(ShoppingList shoppingList) {

        shoppingListRepository.save(shoppingList);
        return shoppingList;
    }
}
