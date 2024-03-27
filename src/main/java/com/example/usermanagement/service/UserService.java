package com.example.usermanagement.service;

import com.example.usermanagement.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel createUser(UserModel user);

    List<UserModel> findBySurName(String surName);
}
