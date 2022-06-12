package com.mtit.user.controller;

import com.mtit.user.entity.User;
import com.mtit.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetails")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/storeUser")
    public ResponseEntity<String> saveUser( @RequestBody User user){
        Integer id = service.saveUser(user);
        return  new ResponseEntity<String>("User No'"+id+"' Successfully Saved!", HttpStatus.OK);

    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUserDetails(){
        List<User> list = service.getAllUserDetails();
        return new ResponseEntity<List<User>>(list,HttpStatus.OK);
    }

    @GetMapping("/getUserById/{userID}")
    public ResponseEntity<User> getUserById(@PathVariable("userID")  Integer userID){
        User usr = service.getUserById(userID);
        return new ResponseEntity<User>(usr,HttpStatus.OK);
    }

    @PutMapping("/updateUser/{userID}")
    public ResponseEntity<String> updateUser( @PathVariable("userID") Integer userID,  @RequestBody User user){
        User userFromDb = service.getUserById(userID);
        userFromDb.setUserID(user.getUserID());
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setItemID(user.getItemID());
        Integer id = service.saveUser(userFromDb);
        return new ResponseEntity<String>("User No '"+id+"'Updated Successfully!",HttpStatus.OK);

    }

    @DeleteMapping("deleteUser/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable("userID") Integer userID){
        service.deleteUser(userID);
        return new ResponseEntity<String>("User No'"+userID+"'Deleted Successfully!",HttpStatus.OK);
    }
}
