package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.repositories.PlannedMealRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlannedMealController {

    private final PlannedMealRepository plannedMealrepository;
    public PlannedMealController(PlannedMealRepository plannedMealrepository) { this.plannedMealrepository = plannedMealrepository; }


    @RequestMapping("/meals")
    public String getUsers(Model model){
        model.addAttribute("meals", plannedMealrepository.findAll());

        return "meals/list";
    }

}
