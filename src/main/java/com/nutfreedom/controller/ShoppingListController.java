package com.nutfreedom.controller;

import com.nutfreedom.model.ShoppingList;
import com.nutfreedom.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ShoppingListController {

    @Autowired
    private ShoppingListService service;



    @PostMapping("/shoppinglist")
    public void addShoppingList(@RequestBody ShoppingList shoppingList) {
        this.service.addShoppingList(shoppingList);
    }

    @DeleteMapping("/shoppinglist")
    public void deleteShoppingList(@RequestBody ShoppingList shoppingList) {
        this.service.deleteShoppingList(shoppingList.getId());
    }

    @GetMapping("/shoppinglists")
    public List<ShoppingList> getShoppingLists() {
        return this.service.getAllShoppingLists();
    }

    @GetMapping("/shoppinglist")
    public ShoppingList getShoppingList() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setTitle("eiei");
        return shoppingList;
    }

    @PutMapping("/shoppinglist")
    public void updateShoppingList(@RequestBody ShoppingList shoppingList) {
        this.service.updateShoppingList(shoppingList);
    }

    @GetMapping("/")
    public String home() {
        return "<h1>555555</h1>";
    }

    @GetMapping("/shoppinglist/{shoppingListId}")
    public ShoppingList getShoppingList(@PathVariable int shoppingListId) {
        return this.service.getShoppingListById(shoppingListId);
    }
}
