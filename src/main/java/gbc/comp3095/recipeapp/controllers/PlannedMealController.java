/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen >
 * Student Number: < 101378456 >
 * Date: 07-11-2021
 * Description: The PlannedMealController make sure that the right data from the model layer is being parsed to the right html page
 *********************************************************************************/
package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.services.Implementations.meal.PlannedMealServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlannedMealController {

    private final PlannedMealServiceImpl mealService;
    public PlannedMealController(PlannedMealServiceImpl mealService) {
        this.mealService = mealService;
    }

    @RequestMapping("/meals")
    public String getUsers(Model model){
        model.addAttribute("meals", mealService.findAll());
        return "meals/list";
    }

    @RequestMapping("/createmeal")
    public String getMeals(Model model){
        model.addAttribute("meals", mealService.findAll());
        return "meals/createMeal";
    }
}
