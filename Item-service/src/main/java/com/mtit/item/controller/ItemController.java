package com.mtit.item.controller;

import com.mtit.item.entity.Item;
import com.mtit.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemDetails")
public class ItemController {

    @Autowired
    private ItemService service;

    //Store item
    @PostMapping("/storeItem")
    public ResponseEntity<String> saveItem( @RequestBody Item item){
        Integer id = service.storeItem(item);
        return  new ResponseEntity<String>("Item No'"+id+"' Successfully Saved!", HttpStatus.OK);

    }

    //Retrieve All Items
    @GetMapping("/allItems")
    public ResponseEntity<List<Item>> getAllItemDetails(){
        List<Item> list = service.getAllItemDetails();
        return new ResponseEntity<List<Item>>(list,HttpStatus.OK);
    }

    //Get Single Item
    @GetMapping("/getItemById/{itemNo}")
    public ResponseEntity<Item> getItemById(@PathVariable("itemNo")  Integer itemNo){
        Item itm = service.getItemById(itemNo);
        return new ResponseEntity<Item>(itm,HttpStatus.OK);
    }

    //update item
    @PutMapping("/updateItem/{itemNo}")
    public ResponseEntity<String> updateItem( @PathVariable("itemNo") Integer itemNo,  @RequestBody Item item){
        Item itemFromDb = service.getItemById(itemNo);
        itemFromDb.setItemNo(item.getItemNo());
        itemFromDb.setItemName(item.getItemName());
        itemFromDb.setItemCode(item.getItemCode());
        itemFromDb.setItemPrice(item.getItemPrice());
        itemFromDb.setItemDescription(item.getItemDescription());
        Integer id = service.storeItem(itemFromDb);
        return new ResponseEntity<String>("Item No '"+id+"'Updated Successfully!",HttpStatus.OK);

    }

    //Delete Item
    @DeleteMapping("deleteItem/{itemNo}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemNo") Integer itemNo){
        service.deleteItem(itemNo);
        return new ResponseEntity<String>("Item No'"+itemNo+"'Deleted Successfully!",HttpStatus.OK);
    }
}
