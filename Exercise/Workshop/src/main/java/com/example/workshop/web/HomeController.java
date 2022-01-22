package com.example.workshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class HomeController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
