/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Provides all the recipes created by the current user. Currently defaulted to user with id 1
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
public class RecipeController {

    private final UserServiceImpl userService;

    @Autowired
    public RecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/recipes")
    public String getRecipes(Model model){
        User user = userService.findById(1L).get();
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("recipe", new Recipe());
        return "recipes/list";
    }



}
