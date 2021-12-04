/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Implementation of User service allows for CRUD operation on it's relations
 *********************************************************************************/
package gbc.comp3095.recipeapp.services.Implementations.user;

import gbc.comp3095.recipeapp.models.*;
import gbc.comp3095.recipeapp.repositories.*;
import gbc.comp3095.recipeapp.services.Interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final MealRepository mealRepository;
    private final ItemRepository itemRepository;
    private final ShoppingListRepository shoppingListRepository;

    private final IngredientRepository ingredientRepository;




    @Autowired
    public UserServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository,
                           MealRepository mealRepository, ItemRepository itemRepository,
                           ShoppingListRepository shoppingListRepository,
                           IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;

        this.recipeRepository = recipeRepository;
        this.mealRepository = mealRepository;
        this.itemRepository = itemRepository;
        this.shoppingListRepository = shoppingListRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Optional<User> find(User object) {

        return userRepository.findById(object.getId());
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User object) {
        userRepository.save(object);
        return object;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

        Optional<User> user  = userRepository.findById(id);
        userRepository.delete(user.get());
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);

    }
    //TODO: is this really necessary?
    private Recipe findRecipe(Recipe recipe){
        Optional<Recipe> searchRecipe = recipeRepository.findById(recipe.getId());
        Recipe foundRecipe = searchRecipe.get();
        return foundRecipe;
    }

    @Override
    public Meal createMeal(User user, Meal meal) {
        meal.setMealAuthor(user);
        user.getMeals().add(meal);
        mealRepository.save(meal);
        userRepository.save(user);

        return meal;
    }

    @Override
    public Recipe createRecipe(User user, Recipe recipe) {
        recipe.setRecipeAuthor(user);
        user.getCreatedRecipes().add(recipe);
        recipe.setRecipeAuthor(user);
        Iterator<Ingredient> ingredientIterator = recipe.getIngredients().iterator();
        recipeRepository.save(recipe);
       while(ingredientIterator.hasNext()){
            Ingredient ingredient = ingredientIterator.next();
            ingredient.setRecipe(recipe);
           // recipe.getIngredients().add(ingredient);
            ingredientRepository.save(ingredient);
        }

        recipeRepository.save(recipe);
        userRepository.save(user);

        return recipe;
    }


    @Override
    public void addFavouriteRecipe(User user, Recipe recipe) {

        Recipe foundRecipe = findRecipe(recipe);

        user.getFavouriteRecipes().add(foundRecipe);

        foundRecipe.addFavouritedBy(user);
        userRepository.save(user);
        recipeRepository.save(foundRecipe);
    }

    @Override
    public void removeFavouriteRecipe(User user, Recipe recipe) {

        Recipe foundRecipe = findRecipe(recipe);

        user.getFavouriteRecipes().remove(foundRecipe);

        foundRecipe.removeFavouritedBy(user);
        userRepository.save(user);
        recipeRepository.save(foundRecipe);
    }

    @Override
    public void addShoppingListItem(User user, Item item){
        ShoppingList shoppingList = user.getShoppingList();
        item.setShoppingList(shoppingList);
        itemRepository.save(item);



        shoppingList.addItem(item);
        user.setShoppingList(shoppingList);
        shoppingListRepository.save(shoppingList);
        userRepository.save(user);




    }

    @Override
    @Transactional
    public void createUser(User user) {

        // initialize user with an empty shopping list
        ShoppingList shoppingList = new ShoppingList(user.getUserName() + "'s shopping list");
        shoppingList.setShoppingListAuthor(user);


        //save user
        userRepository.save(user);

        //save the shopping list
        shoppingList = shoppingListRepository.save(shoppingList);
        user.setShoppingList(shoppingList);

        userRepository.save(user);


    }
}
