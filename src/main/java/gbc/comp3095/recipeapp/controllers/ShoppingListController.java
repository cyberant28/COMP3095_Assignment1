package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.*;
import gbc.comp3095.recipeapp.services.Implementations.ingredient.IngredientServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.shoppingList.ShoppingListServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ShoppingListController {


    private final ShoppingListServiceImpl shoppingListService;
    private final UserServiceImpl userService;
    private final IngredientServiceImpl ingredientService;

    public ShoppingListController(ShoppingListServiceImpl shoppingListService, UserServiceImpl userService, IngredientServiceImpl ingredientService) {
        this.shoppingListService = shoppingListService;
        this.userService = userService;
        this.ingredientService = ingredientService;
    }


    @PostMapping("/additem/{id}")
    public String addItem(@ModelAttribute ShoppingList shoppingList, Model model, @PathVariable("id") String pathId) {
        model.addAttribute("shoppingList", shoppingList);
        model.addAttribute("newItem", new Item());
        User user = userService.findById(1L).get();
        shoppingListService.createShoppingList(shoppingList);
        Optional<Ingredient> ingredientOptional = ingredientService.findById(Long.parseLong(pathId));
        Ingredient ingredient = ingredientOptional.get();
        assert ingredient != null;
        userService.addShoppingListItem(user, new Item(ingredient.getIngredientName(), -1));

        model.addAttribute("items", user.getShoppingList().getItems());

        return "shoppingList/list";

    }


    @PostMapping("/addI")
    public String addI(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
        User user = userService.findById(1L).get();
        userService.addShoppingListItem(user, item);
        return "redirect:/recipes";
    }



        @RequestMapping("/shoppingList")
    public String getShoppingList(Model model){
        model.addAttribute("shoppinglist", new ShoppingList());
        model.addAttribute("newItem", new Item());
        User user = userService.findById(1L).get();
        model.addAttribute("items", user.getShoppingList().getItems());


        return "shoppingList/list";
    }


}
