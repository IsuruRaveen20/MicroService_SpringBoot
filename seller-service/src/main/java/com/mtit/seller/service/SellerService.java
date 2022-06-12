package com.mtit.seller.service;

import com.mtit.seller.entity.Seller;

import java.util.List;

public interface SellerService {
    public Integer saveSeller(Seller seller);

    public List<Seller> getAllSellers();
    public Seller getSellerById(Integer sellerId);

    public void deleteSeller(Integer sellerId);

}
