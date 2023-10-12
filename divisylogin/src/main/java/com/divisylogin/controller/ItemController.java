package com.divisylogin.controller;


import com.divisylogin.model.Item;
import com.divisylogin.model.ItemRepository;
import com.divisylogin.model.ItemRequest;
import com.divisylogin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @Autowired private ItemService itemService;
    @Autowired private ItemRepository itemRepository;

    @PostMapping("/create")
    ResponseEntity<Item>addItem(@RequestBody ItemRequest itemRequest){
        Item item = itemService.createItem(itemRequest.getName(), itemRequest.getPrice());
        return ResponseEntity.ok(item);
    }
    @GetMapping
    ResponseEntity<List<Item>>getAllItems(){
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/id/{id}")
    ResponseEntity<Item> findItemById(@PathVariable("id") Long id) {
        Optional<Item> itemOpt = itemRepository.findById(id);
        if (itemOpt.isPresent()) {
            return ResponseEntity.ok(itemOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
