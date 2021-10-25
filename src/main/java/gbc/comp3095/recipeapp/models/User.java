package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String password;



    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ManyToMany(mappedBy = "users")
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<PlannedMeal> plannedMeals = new HashSet<>();


    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, Set<Recipe> recipes, Set<PlannedMeal> plannedMeals) {

        this.userName = userName;
        this.recipes = recipes;
        this.plannedMeals = plannedMeals;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    public String getUserName() {
        return userName;
    }
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<Recipe> getRecipes() { return recipes; }

    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }

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
                ", recipes=" + recipes +
                ", plannedMeals=" + plannedMeals +
                '}';
    }
}
