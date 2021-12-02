/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen , Saad Khan >
 * Student Number: < 101378456 , 101157307 >
 * Date: 07-11-2021
 * Description: The CreateRecipeController make sure that the right data from the model layer is being parsed to the right html page
 *********************************************************************************/
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
public class CreateRecipeController {

    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;
    @Autowired
    public CreateRecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping("/addrecipe")
    public String getRecipes(Model model){
        model.addAttribute("recipe", new Recipe());
        return "recipes/createRecipe";
    }

    @PostMapping("/addrecipe")
    public String addRecipe(@ModelAttribute Recipe recipe, Model model) {
        model.addAttribute("recipe", recipe);
        User user = userService.findById(1L).get();
        userService.createRecipe(user, recipe);
        return "redirect:/recipes";
    }

    @PostMapping("/editrecipe/{id}")
    public String editRecipe(@ModelAttribute Recipe recipe, @PathVariable("id") String pathId, Model model) {
        model.addAttribute("recipe", recipe);
        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            recipeService.updateRecipeTitleDirections(recipeId, recipe.getTitle(), recipe.getDirections(), recipe.getIngredients());
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid id in path");
        }
     return "redirect:/home";
    }
}
