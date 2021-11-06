package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateRecipeController {

    private final RecipeServiceImpl recipeService;
    @Autowired
    public CreateRecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/addrecipe")
    public String getRecipes(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "recipes/createRecipe";
    }



}
