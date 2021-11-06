package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
