
/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Entity for managing the recipes and their relations
 *********************************************************************************/
package gbc.comp3095.recipeapp.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe extends BaseEntity{

    @Column(name = "title")
    private String title;
    @Column(name = "description")//TODO:Convert to description
    private String description;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "steps")
    private String steps;

    @OneToMany( mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();




    private boolean isAdded;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_favourited_by", joinColumns = @JoinColumn( name = "recipe_id"),  inverseJoinColumns = @JoinColumn( name = "user_id"))
    private Set<User> favouritedBy = new HashSet<>();

    @ManyToOne()
    @JoinTable(name = "recipe_author", joinColumns = @JoinColumn( name = "recipe_id"))
    private User recipeAuthor;

    public Recipe() {
    }

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(String title, String description, User recipeAuthor, Set<User> users, Set<Ingredient> ingredients, String steps) {
        this.title = title;
        this.description = description;
        this.recipeAuthor = recipeAuthor;
        this.favouritedBy = users;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    //Steps

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    /*public List<Step> getStepsAsList(){
        return new ArrayList<Step>(steps);
    }*/

  /*  public void addStep(Step step) {this.steps.add(step);}

    public void removeStep(Step step) {this.steps.remove(step);}*/

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public Long getId() { return super.getId(); }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String descriptions) { this.description = descriptions; }

    public Set<User> getFavouritedBy() { return favouritedBy; }
    public Boolean checkIfFavouritedBy(String userIdString) {
        try {
            Long userId = Long.valueOf(userIdString);

            for(User user : favouritedBy){
                if(user.getId() ==  userId){
                    return true;
                }
            }
        }
        catch (RuntimeException exception){
            throw new RuntimeException("Invalid User Id");
        }
       return false;
    }

    public void setFavouritedBy(Set<User> users) { this.favouritedBy = users; }

    public void addFavouritedBy(User user) { this.favouritedBy.add(user); }

    public void removeFavouritedBy(User user) { this.favouritedBy.remove(user); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getId(), recipe.getId());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", descriptions='" + description + '\'' +
                '}';
    }

    public User getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(User recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }



}
