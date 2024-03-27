package com.example.usermanagement.controller;

import com.example.usermanagement.model.UserModel;
import com.example.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    //create a new user
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user) {
        if (user == null) {
            throw new NoSuchElementException();
        }
        return userService.createUser(user);
    }

    //find existing users based on the given surname
    @RequestMapping(value = "/findBySurName/{surName}", method = RequestMethod.GET)
    public List<UserModel> findBySurName(@PathVariable("surName") String surName) {
        if (surName == null) {
            throw new IllegalArgumentException();
        }

        return userService.findBySurName(surName);
    }

}
