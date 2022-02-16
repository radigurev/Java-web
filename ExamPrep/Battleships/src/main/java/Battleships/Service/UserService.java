package Battleships.Service;

import Battleships.models.binding.UserLoginBindingModel;
import Battleships.models.entity.User;
import Battleships.models.service.UserRegisterServiceModel;

public interface UserService {
    void registerUser(UserRegisterServiceModel map);

    User findByUsernameAndPassword(String username, String password);

    void login(String username, long id);

    User findById(long id);
}
