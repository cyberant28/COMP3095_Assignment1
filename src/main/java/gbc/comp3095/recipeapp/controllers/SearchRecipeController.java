package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SearchRecipeController {
    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;


    public SearchRecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }
    //TODO: clean the query
    public String cleanSearchQuery(String query){
        return query;
    }
    @RequestMapping("/search/{searchQuery}")
    public String searchRecipies(Model model, @PathVariable("searchQuery") String searchQuery){
        searchQuery = cleanSearchQuery(searchQuery);
        model.addAttribute("recipes", recipeService.findByTitle(searchQuery));
        return "recipes/search";
    }
}
