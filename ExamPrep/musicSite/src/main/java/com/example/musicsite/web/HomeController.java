package com.example.musicsite.web;

import com.example.musicsite.model.entity.User;
import com.example.musicsite.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage() {
        User user= userService.getCurrentUser();
        return user==null ? "index" : "home";
    }


}
