package gbc.comp3095.recipeapp.repositories;

import gbc.comp3095.recipeapp.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
