package com.mtit.user.service;

import com.mtit.user.entity.User;

import java.util.List;

public interface UserService {

    public Integer saveUser(User item);

    public List<User> getAllUserDetails();

    public User getUserById(Integer userID);

    public void deleteUser(Integer userID);
}
