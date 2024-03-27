package com.example.usermanagement.model;


import javax.persistence.*;

@Entity
public class UserModel {

    @Id //primary key of the current entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to auto increment the id
    private Integer userId;

    private String surName;

    private String firstName;

    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
