package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Step;
import org.springframework.data.repository.CrudRepository;

public interface StepRepository extends CrudRepository<Step, Long> {
}
