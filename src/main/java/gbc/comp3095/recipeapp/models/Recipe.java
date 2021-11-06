package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe extends BaseEntity{

    //Data members:


    @Column(name = "title")
    private String title;
    @Column(name = "direction")
    private String directions; //TODO: should be an array of strings
    @Column(name = "date_created")
    private Date dateCreated;  //TODO: store date created when user creates recipe

    //TODO: why dont these relations work?
    @ManyToMany()
    @JoinTable(name = "user_favourited_by", joinColumns = @JoinColumn( name = "recipe_id"),  inverseJoinColumns = @JoinColumn( name = "user_id"))
    private Set<User> favouritedBy = new HashSet<>();

    @ManyToOne()
    @JoinTable(name = "recipe_author", joinColumns = @JoinColumn( name = "recipe_id"))
    private User recipeAuthor;


    //@ManyToMany()
    //private Set<PlannedMeal> plannedMeals = new HashSet<>();




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

    public void setFavouritedBy(Set<User> users) { this.favouritedBy = users; }

    public void addFavouritedBy(User user) { this.favouritedBy.add(user); }


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
