/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen, Saad Khan , Gustavo Beltran>
 * Student Number: < 101378456 , 101157307, 101225087 >
 * Date: 07-11-2021
 * Description: Serves the home page with data and serves register and login pages
 *********************************************************************************/


package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;

import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
class WelcomeController {
    private final UserServiceImpl userService;
    private final RecipeServiceImpl recipeService;

    @Autowired
    WelcomeController(UserServiceImpl userService, RecipeServiceImpl recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }
    @GetMapping({"/home/{tab}/{id}"})
    public String welcomeTabWithId(Model model, @PathVariable("tab") String tabName, @PathVariable("id") Long pageLoadRecipeId) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("search" , new String());
        model.addAttribute("tabName", tabName);
        model.addAttribute("pageLoadRecipeId", pageLoadRecipeId);
        return "welcome";
    }

    @GetMapping({"/home/{tab}"})
    public String welcomeTab(Model model, @PathVariable("tab") String tabName) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("search" , new String());
        model.addAttribute("tabName", tabName);
        return "welcome";
    }

    @GetMapping({"","/", "/home"})
    public String welcome(Model model) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("search" , new String());
        model.addAttribute("tabName", "profile");
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
