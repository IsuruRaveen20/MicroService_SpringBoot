package com.mtit.user.service;

import com.mtit.user.entity.User;
import com.mtit.user.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ItemRepository repository;


    @Override
    public Integer saveUser(User user) {
        return repository.save(user).getUserID();
    }

    @Override
    public List<User> getAllUserDetails() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User getUserById(Integer userID) {
        return repository.findById(userID).get();
    }

    @Override
    public void deleteUser(Integer userID) {
        repository.deleteById(userID);
    }
}

