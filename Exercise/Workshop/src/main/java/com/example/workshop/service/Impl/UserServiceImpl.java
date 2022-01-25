package com.example.workshop.service.Impl;

import com.example.workshop.model.entity.UserEntity;
import com.example.workshop.model.entity.enums.LevelEnum;
import com.example.workshop.model.service.UserServiceModel;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.service.UserService;
import com.example.workshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setLevelEnum(LevelEnum.BEGINNER);
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username){
        currentUser.setUsername(username);
        currentUser.setId(id);
    }

    @Override
    public void logOut() {
        currentUser.setUsername(null);
        currentUser.setId(null);
    }

    @Override
    public Object findById(Long id) {
        return userRepository.findById(id).map(user->modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }

    @Override
    public boolean nameExists(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }
}
