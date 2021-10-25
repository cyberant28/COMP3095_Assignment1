package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String directions;

    @ManyToMany()
    @JoinTable(name = "user_recipe", joinColumns = @JoinColumn( name = "user_id"),  inverseJoinColumns = @JoinColumn( name = "recipe_id"))
    private Set<User> users = new HashSet<>();

    @ManyToMany()
    private Set<PlannedMeal> plannedMeals = new HashSet<>();

    public Recipe() {
    }

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(String title, String directions, Set<User> users, Set<PlannedMeal> plannedMeals) {
        this.title = title;
        this.directions = directions;
        this.users = users;
        this.plannedMeals = plannedMeals;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDirections() { return directions; }

    public void setDirections(String directions) { this.directions = directions; }

    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

    public Set<PlannedMeal> getPlannedMeals() { return plannedMeals; }

    public void setPlannedMeals(Set<PlannedMeal> plannedmeals) { this.plannedMeals = plannedmeals; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", directions='" + directions + '\'' +
                ", users=" + users +
                ", plannedMeals=" + plannedMeals +
                '}';
    }
}
