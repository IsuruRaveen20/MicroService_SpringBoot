package com.mtit.seller.service;

import com.mtit.seller.entity.Seller;
import com.mtit.seller.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository repository;

    @Override
    public Integer saveSeller(Seller seller) {
        return repository.save(seller).getSellerId();
    }

    @Override
    public List<Seller> getAllSellers() {
        return (List<Seller>) repository.findAll();
    }

    @Override
    public Seller getSellerById(Integer sellerId) {
        return repository.findById(sellerId).get();
    }

    @Override
    public void deleteSeller(Integer sellerId) {repository.deleteById(sellerId);
    }

}
