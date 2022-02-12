package com.example.coffe_shop.web;

import com.example.coffe_shop.models.View.OrderViewModel;
import com.example.coffe_shop.service.OrderService;
import com.example.coffe_shop.service.UserService;
import com.example.coffe_shop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;


    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model){
        List<OrderViewModel> orders=orderService.findAllOrderByPriceDesc();

        model.addAttribute("orders",orders);
        model.addAttribute("totalTime",orders.stream()
                .map(orderViewModel -> orderViewModel.getCategory()
                .getNeededTime()).reduce(Integer::sum).orElse(null));
        model.addAttribute("users",userService.findAllUsersAndCountOfOrdersInDesc());
        return "home";
    }
}
