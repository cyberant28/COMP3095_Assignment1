/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Saad Khan >
 * Student Number: < 101157307 >
 * Date: 07-11-2021
 * Description: handles user login, adding to fav, and gives users for the user list page
 *********************************************************************************/

package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addfav/{id}")
    public String addFavourite(@ModelAttribute Recipe recipe, @PathVariable("id") String pathId, Model model) {
        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            recipe.setId(recipeId);
            userService.addFavouriteRecipe(user, recipe);
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid recipe id in path");
        }
        return "redirect:/home";
    }

    @PostMapping("/removefav/{id}")
    public String removeFavourite(@ModelAttribute Recipe recipe, @PathVariable("id") String pathId, Model model) {
        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            recipe.setId(recipeId);
            userService.removeFavouriteRecipe(user, recipe);
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid recipe id in path");
        }

        return "redirect:/home";
    }
}
