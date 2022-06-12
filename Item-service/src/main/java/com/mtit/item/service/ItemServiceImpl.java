package com.mtit.item.service;

import com.mtit.item.entity.Item;
import com.mtit.item.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repository;

    @Override
    public Integer storeItem(Item item) {
        return repository.save(item).getItemNo();
    }

    @Override
    public List<Item> getAllItemDetails() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Item getItemById(Integer itemNo) {
        return repository.findById(itemNo).get();
    }

    @Override
    public void deleteItem(Integer itemNo) {
        repository.deleteById(itemNo);
    }
}

