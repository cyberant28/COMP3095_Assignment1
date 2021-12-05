package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Event extends BaseEntity{


    //Data members:
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "eventDate")
    private Calendar eventDate;

    @ManyToMany()
    @JoinTable(name = "meal_event", joinColumns = @JoinColumn( name = "event_id"),  inverseJoinColumns = @JoinColumn( name = "meal_id"))
    private Set<Meal> meals = new HashSet<>();;

    @ManyToOne()
    @JoinTable(name = "user_events", joinColumns = @JoinColumn( name = "event_id"),  inverseJoinColumns = @JoinColumn( name = "user_id"))
    private User eventAuthor;

    public Event() {
    }
    public Event(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getEventDate() {
        return eventDate;
    }

    public void setEventDate(Calendar eventDate) {
        this.eventDate = eventDate;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public User getEventAuthor() {
        return eventAuthor;
    }

    public void setEventAuthor(User eventAuthor) {
        this.eventAuthor = eventAuthor;
    }
}
