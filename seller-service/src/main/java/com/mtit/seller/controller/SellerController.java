package com.mtit.seller.controller;

import com.mtit.seller.entity.Seller;
import com.mtit.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellerDetails")
public class SellerController {

    @Autowired
    private SellerService service;

    @PostMapping("/saveSeller")
    public ResponseEntity<String> saveSeller( @RequestBody Seller seller){
        Integer id = service.saveSeller(seller);
        return  new ResponseEntity<String>("Seller with '"+id+"' has been saved", HttpStatus.OK);

    }
    @GetMapping("/sellerList")
    public ResponseEntity<List<Seller>> getAllSellerDetails(){
        List<Seller> list = service.getAllSellers();
        return new ResponseEntity<List<Seller>>(list,HttpStatus.OK);
    }

    @GetMapping("/getsellerById/{sellerId}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("sellerId")  Integer sellerId){
        Seller std = service.getSellerById(sellerId);
        return new ResponseEntity<Seller>(std,HttpStatus.OK);
    }
    @PutMapping("/updateSeller/{sid}")
    public ResponseEntity<String> updateSeller( @PathVariable("sellerId") Integer sellerId,  @RequestBody Seller seller){
        Seller stdFromDb = service.getSellerById(sellerId);
        stdFromDb.setSellerId(seller.getSellerId());
        stdFromDb.setSellerName(seller.getSellerName());
        stdFromDb.setSellerDescription(seller.getSellerDescription());
        stdFromDb.setSellerStock(seller.getSellerStock());
        Integer id = service.saveSeller(stdFromDb);
        return new ResponseEntity<String>("Seller with '"+id+"' has been updated",HttpStatus.OK);

    }
    @DeleteMapping("deleteseller/{sellerId}")
    public ResponseEntity<String> deleteSeller(@PathVariable("sellerId") Integer sellerId){
        service.deleteSeller(sellerId);
        return new ResponseEntity<String>("Seller with '"+sellerId+"' has been deleted",HttpStatus.OK);
    }
}
