/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen >
 * Student Number: < 101378456 >
 * Date: 07-11-2021
 * Description: The WelcomeController make sure that the right data from the model layer is being parsed to the right html page
 *********************************************************************************/
package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.User;

import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WelcomeController {
    private final UserServiceImpl userService;
    private final RecipeServiceImpl recipeService;

    @Autowired
    WelcomeController(UserServiceImpl userService, RecipeServiceImpl recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @GetMapping({"","/","/home"})
    public String welcome(Model model) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", recipeService.findAll());

        return "welcome";
    }



    @GetMapping({"/login"})
    public String login() {
        return "fragments/login";
    }

    @GetMapping("/register")
    public String register() {
        return "fragments/register";
    }


}