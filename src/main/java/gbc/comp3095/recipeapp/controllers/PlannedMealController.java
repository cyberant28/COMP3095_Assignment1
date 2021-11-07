package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.meal.PlannedMealServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
