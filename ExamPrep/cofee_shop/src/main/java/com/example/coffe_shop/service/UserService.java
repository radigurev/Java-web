package com.example.coffe_shop.service;

import com.example.coffe_shop.models.Service.UserServiceModel;
import com.example.coffe_shop.models.entity.Users;

public interface UserService {

    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    Users findById(Long id);
}
