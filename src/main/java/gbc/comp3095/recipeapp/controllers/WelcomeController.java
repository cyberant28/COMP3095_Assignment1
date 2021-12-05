/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen, Saad Khan , Gustavo Beltran>
 * Student Number: < 101378456 , 101157307, 101225087 >
 * Date: 07-11-2021
 * Description: Serves the home page with data and serves register and login pages
 *********************************************************************************/


package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.User;

import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/**")
    public String handler(ModelMap model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        model.addAttribute("uri", request.getRequestURI());
        model.addAttribute("user", auth.getName());
        model.addAttribute("roles", auth.getAuthorities());
        return "app";
    }
}
