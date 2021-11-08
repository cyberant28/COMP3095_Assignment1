package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class UserController {

  private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) { this.userService = userService; }

    @RequestMapping("/users")
    public String getUsers(Model model){

        model.addAttribute("users", userService.findAll());

        return "users/list";
    }

    @RequestMapping("/login")
    public String login(Model model){

        model.addAttribute("users", userService.findAll());

        return "fragments/login";
    }

    @PostMapping("/addfav/{recipe_id}\"")
    public String editRecipe(@ModelAttribute Recipe recipe, @PathVariable("recipe_id") String pathId, Model model) {



        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            userService.addFavouriteRecipe(user, recipe);
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid recipe id in path");
        }

        return "redirect:/home";
    }


}
