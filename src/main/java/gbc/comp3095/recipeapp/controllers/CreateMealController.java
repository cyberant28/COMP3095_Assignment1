/*********************************************************************************
 * Project: < COMP3095_Assignment2 >
 * Assignment: < assignment 2 >
 * Author(s): < Gustavo Beltran >
 * Student Number: < 101225087 >
 * Date: 12-05-2021
 *********************************************************************************/
package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Meal;
import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.meal.MealServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateMealController {

    private final MealServiceImpl mealService;
    private final UserServiceImpl userService;


    public CreateMealController(MealServiceImpl mealService, UserServiceImpl userService) {
        this.mealService = mealService;
        this.userService = userService;
    }

    @RequestMapping("/addmeal")
    public String getMeals(Model model){
        model.addAttribute("meals", mealService.findAll());
        model.addAttribute("meal", new Meal());
        User user = userService.findById(1L).get();
        model.addAttribute("recipes", user.getRecipes());
        return "meals/createMeal";    }



//    @PostMapping("/editmeal/{id}")
//    public String editMeal(@ModelAttribute Meal meal, @PathVariable("id") String pathId, Model model) {
//        model.addAttribute("meal", meal);
//        User user = userService.findById(1L).get();
//        model.addAttribute("recipes", user.getRecipes());
//        try{
//            Long mealId = Long.valueOf(pathId);
//            mealService.updateMealTitle(mealId, meal.getTitle());
//        }
//        catch (Exception exception){
//            throw new RuntimeException("Invalid id in path");
//        }
//        return "redirect:/meals";
//    }

    @PostMapping(value = "/addmeal", params = {"title", ""})
    public String addMeal(@ModelAttribute Meal meal, Model model) {
        model.addAttribute("meal", meal);
        User user = userService.findById(1L).get();
        userService.createMeal(user, meal);
        return "redirect:/meals";
    }
}
