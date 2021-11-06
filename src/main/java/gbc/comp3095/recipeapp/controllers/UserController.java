package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
