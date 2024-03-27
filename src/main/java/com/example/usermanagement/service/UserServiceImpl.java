package com.example.usermanagement.service;

import com.example.usermanagement.model.UserModel;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    //create a new user with the provided user details
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public List<UserModel> findBySurName(String surName) {
        List<UserModel> users = userRepository.findBySurName(surName);

        if (users.isEmpty()) {
            return null;
        }
        return users;
    }
}
