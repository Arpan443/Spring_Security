package com.pro.Spring_Boot_Security.controllers;

import com.pro.Spring_Boot_Security.model.User;
import com.pro.Spring_Boot_Security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userService.getUsers();
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable ("username") String username){
        return this.userService.getUser(username);
    }
    @PostMapping("/")
    public User add( @RequestBody User user){
        return this.userService.addUser(user);
    }

}
