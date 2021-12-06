/*********************************************************************************
 * Project: < COMP3095_Assignment1 >
 * Assignment: < assignment 1 >
 * Author(s): < Fred Pedersen , Saad Khan >
 * Student Number: < 101378456 , 101157307 >
 * Date: 07-11-2021
 * Description: The CreateRecipeController make sure that the right data from the model layer is being parsed to the right html page
 *********************************************************************************/
package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.Step;
import gbc.comp3095.recipeapp.models.User;
import org.springframework.validation.BindingResult;
import gbc.comp3095.recipeapp.services.Implementations.recipe.RecipeServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CreateRecipeController {

    private final RecipeServiceImpl recipeService;
    private final UserServiceImpl userService;
    @Autowired
    public CreateRecipeController(RecipeServiceImpl recipeService, UserServiceImpl userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping("/addrecipe")
    public String getRecipes(Model model){
        model.addAttribute("recipe", new Recipe());
        return "recipes/createRecipe";
    }
    @RequestMapping(value = "add")
    public String add(Recipe recipe) {
        return "recipes/createRecipe";
    }

    /*@RequestMapping(value = "add", params = {"addStep"})
    public String addStep(final Recipe recipe, final BindingResult result) {
        recipe.getSteps().add(new Step());
        return "recipes/createRecipe";
    }*/

    /*@RequestMapping("/addRecipe")
    public ModelAndView registerSteps() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("recipes/createRecipe");

        Recipe recipe = new Recipe();
        Step step = new Step();
        step.setStep("");
        recipe.getSteps().add(step);
        mv.addObject("recipe", recipe);

        return mv;
    }*/


    @PostMapping("/addrecipe")
    public String addRecipe(@ModelAttribute Recipe recipe, Model model) {
        model.addAttribute("recipe", recipe);
        User user = userService.findById(1L).get();
        userService.createRecipe(user, recipe);

        return "redirect:/recipes";
    }

    @PostMapping("/editrecipe/{id}")
    public String editRecipe(@ModelAttribute Recipe recipe, @PathVariable("id") String pathId, Model model) {
        model.addAttribute("recipe", recipe);
        User user = userService.findById(1L).get();
        try{
            Long recipeId = Long.valueOf(pathId);
            recipeService.updateRecipeTitleDirections(recipeId, recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(), recipe.getSteps());
        }
        catch (Exception exception){
            throw new RuntimeException("Invalid id in path");
        }
     return "redirect:/home";
    }
}
