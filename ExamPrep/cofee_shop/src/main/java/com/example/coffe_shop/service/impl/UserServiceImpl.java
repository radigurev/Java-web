package com.example.coffe_shop.service.impl;

import com.example.coffe_shop.models.Service.UserServiceModel;
import com.example.coffe_shop.models.View.UserViewModel;
import com.example.coffe_shop.models.entity.Users;
import com.example.coffe_shop.repository.UserRepository;
import com.example.coffe_shop.service.UserService;
import com.example.coffe_shop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel map) {
        Users user = modelMapper.map(map,Users.class);
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
       return userRepository
               .findByUsernameAndPassword(username,password)
               .map(user->modelMapper.map(user,UserServiceModel.class))
               .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersAndCountOfOrdersInDesc() {

        return userRepository.findAllByOrdersDesc().stream().map(user -> {
            UserViewModel userViewModel=new UserViewModel();
            userViewModel.setUsername(user.getUsername());
            userViewModel.setCountOfOrders(user.getOrders().size());

            return userViewModel;
        }).collect(Collectors.toList());
    }
}
