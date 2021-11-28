package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.Recipe;
import gbc.comp3095.recipeapp.models.ShoppingList;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.shoppingList.ShoppingListServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingListController {


    private final ShoppingListServiceImpl shoppingListService;

    public ShoppingListController(ShoppingListServiceImpl shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @RequestMapping("/shoppingList")
    public String getShoppingList(Model model, ShoppingList shoppingList){
        return "shoppingList/list";
    }

    @PostMapping("/additem")
    public String addItem(@ModelAttribute ShoppingList shoppingList, Model model) {
        model.addAttribute("shoppingList", shoppingList);
        shoppingListService.createShoppingList(shoppingList);
        return "redirect:/shoppingList";
    }


}
