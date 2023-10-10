package com.divisylogin;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/item")
public class ItemController {

    @PostMapping("/create")
    ResponseEntity<Item>addItem(@RequestBody ItemRequest ItemRequest){

        String name = ItemRequest.getName();
        double price = ItemRequest.getPrice();
        Item Item = new Item(0L, name, price);
        return ResponseEntity.ok(Item);

    }
}
