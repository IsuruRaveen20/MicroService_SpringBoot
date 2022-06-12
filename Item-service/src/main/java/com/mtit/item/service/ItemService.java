package com.mtit.item.service;

import com.mtit.item.entity.Item;

import java.util.List;

public interface ItemService {

    //insert Item
    public Integer storeItem(Item item);

    //Retrieve All Items
    public List<Item> getAllItemDetails();

    //Retrieve Single Item
    public Item getItemById(Integer itemNo);

    //Delete Item
    public void deleteItem(Integer itemNo);
}
