package gbc.comp3095.recipeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Step extends BaseEntity
{
    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    private Recipe recipe;


    @Column(name = "step")
    private String step;



    public Step(String step, Recipe recipe) {
        this.recipe = recipe;
        this.step = step;
    }

    public Step() {

    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }



    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
