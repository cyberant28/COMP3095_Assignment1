/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Entity for managing the User and its relations
 *********************************************************************************/
package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User extends BaseEntity{

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "favouritedBy")
    private Set<Recipe> favouriteRecipes = new HashSet<>();

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

    public Long getId() { return super.getId(); }

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

    public Set<Recipe> getFavouriteRecipes() {
        return this.favouriteRecipes;
    }

    public void setFavouriteRecipes(Set<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }

    public Set<Recipe> getCreatedRecipes() {
        return createdRecipes;
    }

    public void setCreatedRecipes(Set<Recipe> createdRecipes) {
        this.createdRecipes = createdRecipes;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", userName='" + userName +
                ", password='" + password + '\'' +
                '}';
    }
}
