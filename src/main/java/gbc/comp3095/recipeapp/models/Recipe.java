
/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Entity for managing the recipes and their relations
 *********************************************************************************/
package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe extends BaseEntity{



    @Column(name = "title")
    private String title;
    @Column(name = "direction")
    private String directions; //TODO: should be an array of strings
    @Column(name = "date_created")
    private Date dateCreated;  //TODO: store date created when user creates recipe

    //TODO: why dont these relations work?
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

    public Recipe(String title, String directions, User recipeAuthor, Set<User> users) {
        this.title = title;
        this.directions = directions;
        this.recipeAuthor = recipeAuthor;
        this.favouritedBy = users;
    }

    public Long getId() { return super.getId(); }


    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDirections() { return directions; }

    public void setDirections(String directions) { this.directions = directions; }

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
                ", directions='" + directions + '\'' +
                '}';
    }

    public User getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(User recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }
}
