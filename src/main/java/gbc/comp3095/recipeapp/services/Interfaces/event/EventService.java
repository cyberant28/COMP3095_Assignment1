package gbc.comp3095.recipeapp.services.Interfaces.event;

import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;

import gbc.comp3095.recipeapp.models.Event;
import gbc.comp3095.recipeapp.services.Interfaces.CrudService;

public interface EventService extends CrudService<Event, Long> {

    Meal addMeal(Event event, Meal meal);

    void updateEventTitle(Long id, String newTitle);
}

