package com.divisylogin.service;

import com.divisylogin.model.Item;
import com.divisylogin.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(String name, double price){

        Item item = new Item();
        item.setPrice(price);
        Item saveItem = itemRepository.save(item);
        return saveItem;
    }
}
