package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EditRecipeController {

    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;
    @Autowired
    public EditRecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping("/editrecipe")
    public String getRecipes(Model model){
        User user = userService.findById(1L).get();
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("recipe", new Recipe());
        return "recipes/editrecipe";
    }

    @PostMapping("/editrecipe/{id}")
    public String editRecipe(@ModelAttribute Recipe recipe, @PathVariable("id") String pathId, Model model) {
        model.addAttribute("recipe", recipe);
        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            recipeService.updateRecipeTitleDirections(recipeId, recipe.getTitle(), recipe.getDescription(), recipe.getIngredients());
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid id in path");
        }
        return "redirect:/recipes";
    }


}
