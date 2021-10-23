package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserRepository userrepository;
    public UserController(UserRepository userRepository) { this.userrepository = userRepository; }

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userrepository.findAll());

        return "users/list";
    }

}
