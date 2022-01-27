package com.example.coffe_shop.web;

import com.example.coffe_shop.service.OrderService;
import com.example.coffe_shop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;

    public HomeController(CurrentUser currentUser, OrderService orderService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(){
     /*   if(currentUser.getId()==null) {
            return "index";
        }

        model.addAttribute("orders",orderService.findAllOrderByPriceDesc());
        return "home";

      */
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("orders",orderService.findAllOrderByPriceDesc());
        return "home";
    }
}
