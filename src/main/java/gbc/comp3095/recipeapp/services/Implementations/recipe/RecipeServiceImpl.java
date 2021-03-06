/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Service implentation for receipe allows for deleting by ID, updating, finding, and a lot more
 *********************************************************************************/
package gbc.comp3095.recipeapp.services.Implementations.recipe;

import gbc.comp3095.recipeapp.models.Ingredient;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.Step;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.services.Interfaces.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;


    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Iterable<Recipe> findByTitle(String searchQuery) {
        return recipeRepository.findByTitleContainingIgnoreCase(searchQuery);
    }

    @Override
    public Optional<Recipe> find(Recipe recipe) {
        return recipeRepository.findById(recipe.getId());
    }


    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    @Override
    public  void updateRecipeTitleDirections(Long id, String newTitle, String newDescription, Set<Ingredient> newIngedients, Set<Step> newSteps) {
        Recipe recipeNew = recipeRepository.findById(id).get();
        recipeNew.setTitle(newTitle);
        recipeNew.setDescription(newDescription);//TODO:Convert to description
        recipeNew.setIngredients(newIngedients);
        recipeNew.setSteps(newSteps);
        recipeRepository.save(recipeNew);
    }

    @Override
    public void deleteById(Long id) {

        recipeRepository.deleteById(id);

    }

    public void updateRecipeTitleDirections(Long recipeId, String title, String description, Set<Ingredient> ingredients) {
    }
}
