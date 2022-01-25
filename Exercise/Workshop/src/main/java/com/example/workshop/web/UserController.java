package com.example.workshop.web;

import com.example.workshop.model.binding.UserLoginBindingModel;
import com.example.workshop.model.binding.UserRegisterBindingModel;
import com.example.workshop.model.service.UserServiceModel;
import com.example.workshop.model.view.UserViewModel;
import com.example.workshop.service.UserService;
import com.example.workshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,

                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        if(userService.nameExists(userRegisterBindingModel.getUsername()))
        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isExists",true);
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
                    .addFlashAttribute("rg.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:login";
        }
       UserServiceModel userServiceModel=userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword());
        if(userServiceModel==null){
            redirectAttributes.addFlashAttribute("isExists", false)
                    .addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
                    .addFlashAttribute("rg.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(),userServiceModel.getUsername());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logOut();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id,Model model){
        model.addAttribute("user", modelMapper.map(userService.findById(id), UserViewModel.class));
        return "profile";
    }

}
