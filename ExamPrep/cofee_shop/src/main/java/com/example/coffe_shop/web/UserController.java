package com.example.coffe_shop.web;

import com.example.coffe_shop.models.Service.UserServiceModel;
import com.example.coffe_shop.models.binding.UserLoginBindingModel;
import com.example.coffe_shop.models.binding.UserRegisterBindingModel;
import com.example.coffe_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }
        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if(!model.containsAttribute("isFound")){
            model.addAttribute("isFound",true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel=userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword());
        if(userServiceModel==null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel).addFlashAttribute("isFound",false);
            return "redirect:login";
        }
        userService.loginUser(userServiceModel.getId(),userServiceModel.getUsername());

        return "redirect:/";
    }
}
