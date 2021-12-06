/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Implementation for the meal service allows adding, retrieving recipes etc.
 *********************************************************************************/

package gbc.comp3095.recipeapp.services.Implementations.meal;

import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.repositories.MealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.services.Interfaces.meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, RecipeRepository recipeRepository) {
        this.mealRepository = mealRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public Optional<Meal> find(Meal meal) {
        return mealRepository.findById(meal.getId());
    }

    @Override
    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Iterable<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    @Override
    public void deleteById(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public Recipe addRecipe(Meal meal, Recipe recipe){
        Optional<Recipe> searchRecipe = recipeRepository.findById(recipe.getId());
        Recipe foundRecipe = searchRecipe.get();


        meal.getRecipes().add(foundRecipe);

        recipeRepository.save(foundRecipe);
        mealRepository.save(meal);

        return foundRecipe;


    }

    public void updateMealTitle(Long id, String newTitle) {
        Meal mealNew = mealRepository.findById(id).get();
        mealNew.setTitle(newTitle);
        mealRepository.save(mealNew);
    }

    @Override
    public void updateMeal(Meal meal, User user){
        meal.setMealAuthor(user);
        mealRepository.save(meal);
    }
}
