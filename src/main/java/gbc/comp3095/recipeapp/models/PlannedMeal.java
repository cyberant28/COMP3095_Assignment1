package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class PlannedMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date datecreated;

    @ManyToMany()
    @JoinTable(name = "recipe_meal", joinColumns = @JoinColumn( name = "recipe_id"),  inverseJoinColumns = @JoinColumn( name = "meal_id"))
    private Set<Recipe> recipes;

    @ManyToMany()
    @JoinTable(name = "user_meals", joinColumns = @JoinColumn( name = "user_id"),  inverseJoinColumns = @JoinColumn( name = "meal_id"))
    private Set<User> users;



    public PlannedMeal() {
    }

    public PlannedMeal(String title) {
        this.title = title;
    }

    public PlannedMeal(String title, Set<Recipe> recipes, Set<User> users) {
        this.title = title;
        this.recipes = recipes;
        this.users = users;
    }

    public PlannedMeal(String title, String description, Date datecreated, Set<Recipe> recipes, Set<User> users) {
        this.title = title;
        this.description = description;
        this.datecreated = datecreated;
        this.recipes = recipes;
        this.users = users;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getDatecreated() { return datecreated; }

    public void setDatecreated(Date datecreated) { this.datecreated = datecreated; }

    public Set<Recipe> getRecipes() { return recipes; }

    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }

    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannedMeal plannedmeal = (PlannedMeal) o;
        return Objects.equals(id, plannedmeal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PlannedMeal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datecreated=" + datecreated +
                ", recipes=" + recipes +
                ", users=" + users +
                '}';
    }
}
