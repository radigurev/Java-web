package com.example.workshop.service;

import com.example.workshop.model.service.UserServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logOut();

    Object findById(Long id);

    boolean nameExists(String username);}
