package com.example.workshop.web;

import com.example.workshop.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("pictures",pictureService.findAllUrls());
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
}