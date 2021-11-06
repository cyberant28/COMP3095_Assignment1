package gbc.comp3095.recipeapp.system;

import gbc.comp3095.recipeapp.models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class WelcomeController {

    @GetMapping({"","/"})
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
