package com.example.workshop.model.service;

import com.example.workshop.model.entity.Role;
import com.example.workshop.model.entity.enums.LevelEnum;

import java.util.Set;

public class UserServiceModel {
    private Long id;
    private String fullName,username,password,email;
    private LevelEnum levelEnum;
    private int age;
    private Set<Role> roles;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LevelEnum getLevelEnum() {
        return levelEnum;
    }

    public void setLevelEnum(LevelEnum levelEnum) {
        this.levelEnum = levelEnum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
