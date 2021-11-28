package gbc.comp3095.recipeapp.controllers;

import gbc.comp3095.recipeapp.models.ShoppingList;
import gbc.comp3095.recipeapp.models.User;
import gbc.comp3095.recipeapp.services.Implementations.shoppingList.ShoppingListServiceImpl;
import gbc.comp3095.recipeapp.services.Implementations.user.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingListController {


    private final ShoppingListServiceImpl shoppingListService;
    private final UserServiceImpl userService;

    public ShoppingListController(ShoppingListServiceImpl shoppingListService, UserServiceImpl userService) {
        this.shoppingListService = shoppingListService;
        this.userService = userService;
    }


    @PostMapping("/additem")
    public String addItem(@ModelAttribute ShoppingList shoppingList, Model model) {
        model.addAttribute("shoppingList", shoppingList);
        shoppingListService.createShoppingList(shoppingList);
        return "redirect:/shoppingList";
    }

    @RequestMapping("/shoppingList")
    public String getShoppingList(Model model){
        model.addAttribute("shoppinglist", new ShoppingList());
        User user = userService.findById(1L).get();
        model.addAttribute("items", user.getShoppingList().getItems());


        return "shoppingList/list";
    }


}
