/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen >
 * Student Number: < 101378456 >
 * Date: 07-11-2021
 * Description: The CreateUserController make sure that the right data from the model layer is being parsed to the right html page
 *********************************************************************************/
package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CreateUserController {

    private final UserServiceImpl userService;

    @Autowired
    public CreateUserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/adduser")
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        return "fragments/createUser";
    }

//    @RequestMapping("/addrecipe")
//    public String getRecipes(Model model){
//        model.addAttribute("recipe", new Recipe());
//        return "recipes/list";
//    }


    @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        userService.createUser(user);

        return "redirect:/";
    }
}
