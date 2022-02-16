package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import shop.models.entity.User;
import shop.models.service.UserRegisterServiceModel;
import shop.repository.UserRepository;
import shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterServiceModel map) {
        userRepository.save(modelMapper.map(map, User.class));
    }

    @Override
    public UserRegisterServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).map(user -> modelMapper.map(user,UserRegisterServiceModel.class)).orElse(null);
    }
}
