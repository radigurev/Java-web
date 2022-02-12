package shop.service;

import shop.models.service.UserRegisterServiceModel;

public interface UserService {
    void register(UserRegisterServiceModel map);

    UserRegisterServiceModel findByUsernameAndPassword(String username, String password);
}
