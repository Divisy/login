package com.divisylogin.service;

import com.divisylogin.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImp implements ItemService {
    public static long id = 0L;
    public List<Item> Items = new ArrayList<>();
    public Item createItem(String name, double price){

        Item Item = new Item( id++, name, price);
        Items.add(Item);
        return Item;
    }
}
