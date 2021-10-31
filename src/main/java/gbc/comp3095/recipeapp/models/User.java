package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    //Data members:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String password;

    //TODO: why dont these relations work?
    @ManyToMany(mappedBy = "favouritedBy")
    private Set<Recipe> favouritedRecipes = new HashSet<>();

    @OneToMany(mappedBy = "recipeAuthor")
    private Set<Recipe> createdRecipes = new HashSet<>();

    @OneToMany(mappedBy = "mealAuthor")
    private Set<PlannedMeal> plannedMeals = new HashSet<>();






    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, Set<Recipe> recipes, Set<PlannedMeal> plannedMeals) {

        this.userName = userName;
        this.createdRecipes = recipes;
        this.plannedMeals = plannedMeals;
    }


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<Recipe> getRecipes() { return createdRecipes; }

    public void setRecipes(Set<Recipe> recipes) { this.createdRecipes = recipes; }

    public Set<PlannedMeal> getPlannedMeals() { return plannedMeals; }

    public void setPlannedMeals(Set<PlannedMeal> plannedMeals) { this.plannedMeals = plannedMeals; }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName +
                ", password='" + password + '\'' +
                ", createdRecipes=" + createdRecipes +
                ", plannedMeals=" + plannedMeals +
                '}';
    }




}
