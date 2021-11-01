package gbc.comp3095.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "index/index";
    }

    @GetMapping("/register")
    public String register(){
        return "index/register";
    }

    @GetMapping("/home")
    public String home(Model model){
        return "index/home";
    }

    @GetMapping("/search")
    public String search(){
        return "index/search";
    }

    @GetMapping("/planner")
    public String planner(){
        return "index/planner";
    }

    @GetMapping("/forum")
    public String forum(){
        return "index/forum";
    }

    @GetMapping("/recipeBook")
    public String recipeBook(){
        return "index/recipeBook";
    }

    @GetMapping("/createRecipe")
    public String createRecipe(){
        return "index/createRecipe";
    }

    @GetMapping("/favorites")
    public String favorites(){
        return "index/favorites";
    }


}
