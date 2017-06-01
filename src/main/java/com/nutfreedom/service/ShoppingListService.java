package com.nutfreedom.service;

import com.nutfreedom.model.ShoppingList;
import com.nutfreedom.repository.ShoppingListRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    public void deleteShoppingList(int id) {
        ShoppingList shoppingList = getShoppingListById(id);
        this.repository.delete(shoppingList);
    }

    public void addShoppingList(ShoppingList shoppingList) {
        repository.save(shoppingList);
    }

    public void updateShoppingList(@RequestBody ShoppingList shoppingList) {
        ShoppingList shoppingList1 = getShoppingListById(shoppingList.getId());
        shoppingList1.setTitle(shoppingList.getTitle());
        this.repository.save(shoppingList1);
    }

    public List<ShoppingList> getAllShoppingLists() {
        List<ShoppingList> shoppingLists = new ArrayList<>();
        repository.findAll().forEach(shoppingLists::add);
        return shoppingLists;
    }

    public ShoppingList getShoppingListById(int shoppingListId) {
        return this.repository.findOne(shoppingListId);
    }
}
