package com.example.usermanagement.repository;

import com.example.usermanagement.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    List<UserModel> findBySurName(String surName);

}
