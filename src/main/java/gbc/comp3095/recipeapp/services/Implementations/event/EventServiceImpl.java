package gbc.comp3095.recipeapp.services.Implementations.event;

import gbc.comp3095.recipeapp.models.Event;
import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.repositories.EventRepository;
import gbc.comp3095.recipeapp.repositories.MealRepository;
import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.services.Interfaces.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final MealRepository mealRepository;
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(MealRepository mealRepository, EventRepository eventRepository) {
        this.mealRepository = mealRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> find(Event event) {
        return eventRepository.findById(event.getId());
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Meal addMeal(Event event, Meal meal){
        Optional<Meal> searchMeal = mealRepository.findById(meal.getId());
        Meal foundMeal = searchMeal.get();


        event.getMeals().add(foundMeal);

        mealRepository.save(foundMeal);
        eventRepository.save(event);

        return foundMeal;


    }



    @Override
    public void updateEventTitle(Long id, String newTitle) {
        Event eventNew = eventRepository.findById(id).get();
        eventNew.setTitle(newTitle);
        eventRepository.save(eventNew);
    }
}


