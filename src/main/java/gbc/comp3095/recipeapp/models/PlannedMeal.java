package gbc.comp3095.recipeapp.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class PlannedMeal extends BaseEntity{

    //Data members:


    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "mealDate")
    private Calendar mealDate;


    //TODO: why dont these relations work?
    @ManyToMany()
    @JoinTable(name = "recipe_meal", joinColumns = @JoinColumn( name = "meal_id"),  inverseJoinColumns = @JoinColumn( name = "recipe_id"))
    private Set<Recipe> recipes = new HashSet<>();;

    @ManyToOne()
    @JoinTable(name = "user_meals", joinColumns = @JoinColumn( name = "meal_id"),  inverseJoinColumns = @JoinColumn( name = "user_id"))
    private User mealAuthor;



public PlannedMeal(){

}

    public PlannedMeal(String title, Calendar mealDate) {
        this.title = title;
        this.mealDate = mealDate;
    }


    public PlannedMeal(String title, User mealAuthor, Calendar mealDate, String description) {
        this.title = title;
        this.description = description;
        this.mealDate = mealDate;
        this.mealAuthor = mealAuthor;
    }






    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Calendar getMealDate() { return mealDate; }

    public void setMealDate(Calendar mealDate) { this.mealDate = mealDate; }

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
                '}';
    }
}
