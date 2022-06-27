package com.example.musicsite.web;

import com.example.musicsite.model.binding.UserLoginBindingModel;
import com.example.musicsite.model.binding.UserRegisterBindingModel;
import com.example.musicsite.model.entity.User;
import com.example.musicsite.model.service.UserRegisterServiceModel;
import com.example.musicsite.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.ResultSet;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingModel userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        User email=userService.findByEmail(userModel.getEmail());
        User username=userService.findByUsername(userModel.getUsername());

        if(bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword()) || email!=null || username!=null) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.saveUser(modelMapper.map(userModel, UserRegisterServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String getLoginInformation(@Valid UserLoginBindingModel userModel, BindingResult bindingResult,RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }
        User user=userService.findUser(userModel);

        if(user==null) {
            redirectAttributes.addFlashAttribute("isFound",false);
            return "redirect:login";
        }
            userService.loginUser(user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();

        return "redirect:/";
    }


}
