/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: Provides all the recipes stored in the system to the explore recipe page
 *********************************************************************************/

package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExploreRecipesController {


    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;

    @Autowired
    public ExploreRecipesController(RecipeServiceImpl recipeService, UserServiceImpl userService, UserServiceImpl userService1) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping("/explore")
    public String exploreRecipes(Model model){

        model.addAttribute("recipes", recipeService.findAll());
        model.addAttribute("recipe", new Recipe());
        return "recipes/explore";
    }




}
