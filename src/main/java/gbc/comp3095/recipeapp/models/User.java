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

    private String firstname;
    private String lastname;
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<PlannedMeal> plannedmeals = new HashSet<>();


    public User() {
    }

    public User(String firstname, String lastname, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public User(String firstname, String lastname, String password, Set<Recipe> recipes, Set<PlannedMeal> plannedmeals) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.recipes = recipes;
        this.plannedmeals = plannedmeals;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Set<Recipe> getRecipes() { return recipes; }

    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }

    public Set<PlannedMeal> getPlannedmeals() { return plannedmeals; }

    public void setPlannedmeals(Set<PlannedMeal> plannedmeals) { this.plannedmeals = plannedmeals; }

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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", recipes=" + recipes +
                ", plannedmeals=" + plannedmeals +
                '}';
    }
}
