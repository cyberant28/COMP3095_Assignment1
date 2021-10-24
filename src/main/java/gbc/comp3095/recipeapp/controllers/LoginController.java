package gbc.comp3095.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/listOfRecipes")
    public String listOfRecipes(){
        return "index/listOfRecipes";
    }

    @GetMapping("/recipeBook")
    public String recipeBook(){
        return "index/recipeBook";
    }


}
