package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class PlannedMeal extends BaseEntity{

    //Data members:


    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "mealDate")
    private Date mealDate;


    //TODO: why dont these relations work?
    @ManyToMany()
    @JoinTable(name = "recipe_meal", joinColumns = @JoinColumn( name = "meal_id"),  inverseJoinColumns = @JoinColumn( name = "recipe_id"))
    private Set<Recipe> recipes = new HashSet<>();;

    @ManyToOne()
    @JoinTable(name = "user_meals", joinColumns = @JoinColumn( name = "meal_id"),  inverseJoinColumns = @JoinColumn( name = "user_id"))
    private User mealAuthor;





    public PlannedMeal() {
    }

    public PlannedMeal(String title) {
        this.title = title;
    }

    public PlannedMeal(String title, Set<Recipe> recipes, User mealAuthor) {
        this.title = title;
        this.recipes = recipes;
        this.mealAuthor = mealAuthor;
    }

    public PlannedMeal(String title, String description, Date mealDate, Set<Recipe> recipes, User mealAuthor) {
        this.title = title;
        this.description = description;
        this.mealDate = mealDate;
        this.recipes = recipes;
        this.mealAuthor = mealAuthor;
    }

    public PlannedMeal(String title, User user) {
        this.title = title;
        this.mealAuthor = user;

    }




    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getMealDate() { return mealDate; }

    public void setMealDate(Date mealDate) { this.mealDate = mealDate; }

    public Set<Recipe> getRecipes() { return this.recipes; }

    public void setRecipes(Set<Recipe> recipes) { this.recipes = recipes; }

    public User getMealAuthor() { return mealAuthor; }

    public void setMealAuthor(User author) { this.mealAuthor = author; }

    public Long getId() { return super.getId(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannedMeal plannedMeal = (PlannedMeal) o;
        return Objects.equals(getId(), plannedMeal.getId());
    }



    @Override
    public String toString() {
        return "PlannedMeal{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datecreated=" + mealDate +
                ", recipes=" + recipes +
                '}';
    }
}
