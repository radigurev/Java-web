package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage() {

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingModel bindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors() || !bindingModel.getPassword().equals(bindingModel.getConfirmPassword()) || !userService.registerUser(bindingModel)) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", bindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
                return "redirect:register";
        }
            return "redirect:login";
    }

    @GetMapping("/login")
    public String getLoginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBindingModel bindingModel, BindingResult bindingResult,RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", bindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        User user = userService.findUser(bindingModel);

        if(user==null) {
            redirectAttributes.addFlashAttribute("isFound",false);
            return "redirect:login";
        }

        userService.loginUser(user);

        return "redirect:/";
    }



    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {

        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

}
