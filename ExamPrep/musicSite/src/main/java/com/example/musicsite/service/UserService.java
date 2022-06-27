package com.example.musicsite.service;

import com.example.musicsite.model.binding.UserLoginBindingModel;
import com.example.musicsite.model.entity.User;
import com.example.musicsite.model.service.UserRegisterServiceModel;

public interface UserService {
    User findByEmail(String email);

    User findByUsername(String username);

    void saveUser(UserRegisterServiceModel map);

    User findUser(UserLoginBindingModel userModel);

    void loginUser(User user);

    User getCurrentUser();
}
