package Battleships.Service.impl;

import Battleships.Service.UserService;
import Battleships.models.entity.User;
import Battleships.models.service.UserRegisterServiceModel;
import Battleships.repository.UserRepository;
import Battleships.util.CurrentUser;
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
    public void registerUser(UserRegisterServiceModel map) {
        User user= modelMapper.map(map,User.class);

        userRepository.saveAndFlush(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).orElse(null);
    }

    @Override
    public void login(String username, long id) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
