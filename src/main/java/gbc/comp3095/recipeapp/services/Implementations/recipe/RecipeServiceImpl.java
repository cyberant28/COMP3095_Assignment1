package gbc.comp3095.recipeapp.services.Implementations.recipe;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.services.Interfaces.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public  void updateRecipeTitleDirections(Long id, String newTitle, String newDirections) {
        Recipe recipeNew = recipeRepository.findById(id).get();
        recipeNew.setTitle(newTitle);
        recipeNew.setDirections(newDirections);
        recipeRepository.save(recipeNew);
    }

    @Override
    public void deleteById(Long id) {

        recipeRepository.deleteById(id);

    }
}
