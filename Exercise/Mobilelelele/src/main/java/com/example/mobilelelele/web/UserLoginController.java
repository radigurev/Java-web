package com.example.mobilelelele.web;

import com.example.mobilelelele.model.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }
    @PostMapping("/users/login")
    public String getLogin(UserLoginDto userLoginDto){

        return "redirect:/index";
    }
}

