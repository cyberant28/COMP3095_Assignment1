package gbc.comp3095.recipeapp.services.Implementations.meal;

import gbc.comp3095.recipeapp.models.PlannedMeal;
import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import gbc.comp3095.recipeapp.services.Interfaces.meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlannedMealServiceImpl implements MealService {

    private final PlannedMealRepository mealRepository;

    @Autowired
    public PlannedMealServiceImpl(PlannedMealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Optional<PlannedMeal> findById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public Optional<PlannedMeal> find(PlannedMeal meal) {
        return mealRepository.findById(meal.getId());
    }

    @Override
    public PlannedMeal save(PlannedMeal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Iterable<PlannedMeal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public void delete(PlannedMeal meal) {
        mealRepository.delete(meal);
    }

    @Override
    public void deleteById(Long id) {
        mealRepository.deleteById(id);
    }
}
