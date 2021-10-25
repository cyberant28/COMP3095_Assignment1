package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.repositories.RecipeRepository;
import gbc.comp3095.recipeapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    public RecipeController(RecipeRepository recipeRepository) { this.recipeRepository = recipeRepository; }

    @RequestMapping("/recipes")
    public String getUsers(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());

        return "recipes/list";
    }
}
