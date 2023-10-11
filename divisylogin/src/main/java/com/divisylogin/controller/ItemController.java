package com.divisylogin.controller;


import com.divisylogin.model.Item;
import com.divisylogin.model.ItemRequest;
import com.divisylogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired private ItemService itemService;

    @PostMapping("/create")
    ResponseEntity<Item>addItem(@RequestBody ItemRequest itemRequest){
        Item item = itemService.createItem(itemRequest.getName(), itemRequest.getPrice());
        return ResponseEntity.ok(item);
    }
}
