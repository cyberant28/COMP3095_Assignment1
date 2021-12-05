package gbc.comp3095.recipeapp.services.Implementations.ingredient;

import gbc.comp3095.recipeapp.models.Ingredient;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.Step;
import gbc.comp3095.recipeapp.repositories.IngredientRepository;
import gbc.comp3095.recipeapp.services.Interfaces.ingredient.IngredientSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientSerivce {

    private final IngredientRepository ingredientRepository;

@Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Optional<Ingredient> find(Ingredient ingredient) {
        return ingredientRepository.findById(ingredient.getId());
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public void delete(Ingredient ingredient) {
    ingredientRepository.delete(ingredient);

    }

    @Override
    public void deleteById(Long id) {
    ingredientRepository.deleteById(id);
    }

}
