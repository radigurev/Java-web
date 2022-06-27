package com.example.musicsite.service.implementation;

import com.example.musicsite.model.binding.UserLoginBindingModel;
import com.example.musicsite.model.entity.User;
import com.example.musicsite.model.service.UserRegisterServiceModel;
import com.example.musicsite.repository.UserRepository;
import com.example.musicsite.service.UserService;
import com.example.musicsite.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UsersService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void saveUser(UserRegisterServiceModel map) {
        User user=modelMapper.map(map,User.class);
        userRepository.save(user);
    }

    @Override
    public User findUser(UserLoginBindingModel userModel) {
        return userRepository.findByUsernameAndPassword(userModel.getUsername(), userModel.getPassword()).orElse(null);
    }

    @Override
    public void loginUser(User user) {
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
    }

    @Override
    public User getCurrentUser() {
        if(currentUser.getId()==null)
            return null;
        return userRepository.findById(currentUser.getId()).orElse(null);
    }


}
