package gbc.comp3095.recipeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient extends BaseEntity{

        @ManyToOne
        @JoinColumn(name="recipe_id", nullable=false)
        private Recipe recipe;


        @Column(name = "ingredientName")
        private String ingredientName;



        public Ingredient(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public Ingredient() {

        }

        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }



        public Recipe getRecipe() {
            return recipe;
        }

        public void setRecipe(Recipe recipe) {
            this.recipe = recipe;
        }


}
