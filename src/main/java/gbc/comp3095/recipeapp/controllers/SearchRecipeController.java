package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Controller
public class SearchRecipeController {
    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;


    public SearchRecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }



    @GetMapping("/search")
    public String searchRecipes(Model model, @RequestParam String searchQuery){
        Iterable<Recipe> recipesFound  = recipeService.findByTitle(searchQuery);

        boolean foundRecipes = false;

        if(!recipesFound.iterator().hasNext()){
            model.addAttribute("foundRecipesBool",false);
        }
        else{
            model.addAttribute("foundRecipesBool",true);
            model.addAttribute("recipes", recipesFound);
        }

          return "recipes/search";
    }
}
