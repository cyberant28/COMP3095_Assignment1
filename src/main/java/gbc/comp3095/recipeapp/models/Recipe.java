package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {

    //Data members:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String directions; //TODO: should be an array of strings
    private Date dateCreated;  //TODO: store date created when user creates recipe

    //TODO: why dont these relations work?
    @ManyToMany()
    @JoinTable(name = "user_favourited_by", joinColumns = @JoinColumn( name = "user_id"),  inverseJoinColumns = @JoinColumn( name = "recipe_id"))
    private Set<User> favouritedBy = new HashSet<>();

    @ManyToOne()
    @JoinTable(name = "user_author", joinColumns = @JoinColumn( name = "user_id"))
    private User recipeAuthor;

    @ManyToMany()
    private Set<PlannedMeal> plannedMeals = new HashSet<>();




    public Recipe() {
    }

    public Recipe(String title, User recipeAuthor) {
        this.title = title;
        this.recipeAuthor = recipeAuthor;
    }

    public Recipe(String title, String directions, User recipeAuthor, Set<User> users, Set<PlannedMeal> plannedMeals) {
        this.title = title;
        this.directions = directions;
        this.recipeAuthor = recipeAuthor;
        this.favouritedBy = users;
        this.plannedMeals = plannedMeals;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDirections() { return directions; }

    public void setDirections(String directions) { this.directions = directions; }

    public Set<User> getFavouritedBy() { return favouritedBy; }

    public void setFavouritedBy(Set<User> users) { this.favouritedBy = users; }

    public void addFavouritedBy(User user) { this.favouritedBy.add(user); }

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
                ", favouritedBy=" + favouritedBy +
                ", plannedMeals=" + plannedMeals +
                '}';
    }
}
