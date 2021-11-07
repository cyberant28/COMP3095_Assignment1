package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WelcomeController {

    private final UserServiceImpl userService;

    WelcomeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String welcome(Model model) {
        User user = userService.findById(1L).get();
        model.addAttribute("favoriteRecipes", user.getFavouriteRecipes());

        return "welcome";
    }

    @GetMapping({"","/","/home"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "fragments/login";
    }

    @GetMapping("/register")
    public String register() {
        return "fragments/register";
    }


}
