/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen, Saad Khan , Gustavo Beltran>
 * Student Number: < 101378456 , 101157307, 101225087 >
 * Date: 07-11-2021
 * Description: Serves the home page with data and serves register and login pages
 *********************************************************************************/
/*********************************************************************************
 * Project: < COMP3095_Assignment2 >
 * Assignment: < assignment 2 >
 * Author(s): < Fred Pedersen, Saad Khan , Gustavo Beltran>
 * Student Number: < 101378456 , 101157307, 101225087 >
 * Date: 07-11-2021
 * Description: added view recipe details and view meal details
 *********************************************************************************/


package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.User;

import gbc.comp3095.recipeapp.services.Implementations.meal.MealServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class WelcomeController {
    private final UserServiceImpl userService;
    private final RecipeServiceImpl recipeService;
    private final MealServiceImpl mealService;

    @Autowired
    WelcomeController(UserServiceImpl userService, RecipeServiceImpl recipeService, MealServiceImpl mealService) {
        this.userService = userService;
        this.recipeService = recipeService;
        this.mealService = mealService;
    }

    @GetMapping({"","/","/home"})
    public String welcome(Model model) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", user.getRecipes());
        model.addAttribute("search" , new String());
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

    @GetMapping({"/viewfavorites"})
    public String viewfavorites(Model model) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
//        model.addAttribute("recipes", user.getRecipes());
//        model.addAttribute("search" , new String());
        return "recipes/viewfavorites";
    }

    @GetMapping({"/viewdetails"})
    public String viewdetails(Model model) {
        User user = userService.findById(1L).get();
//        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());
        model.addAttribute("recipes", user.getRecipes());
//        model.addAttribute("search" , new String());
        return "recipes/viewdetails";
    }

    @RequestMapping("/mealdetails")
    public String getMeals(Model model){
        model.addAttribute("meals", mealService.findAll());
        model.addAttribute("meal", new Meal());
        User user = userService.findById(1L).get();
        model.addAttribute("recipes", user.getRecipes());
        return "meals/mealdetails";
    }

}
