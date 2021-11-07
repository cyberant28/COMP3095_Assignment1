package gbc.comp3095.recipeapp.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends BaseEntity implements UserDetails {


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



    /**
     * UserDetail methods
     * @return
     */


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    public String getPassword() { return password; }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
