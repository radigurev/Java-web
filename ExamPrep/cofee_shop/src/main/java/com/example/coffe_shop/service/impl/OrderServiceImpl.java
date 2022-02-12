package com.example.coffe_shop.service.impl;

import com.example.coffe_shop.models.Service.OrderServiceModel;
import com.example.coffe_shop.models.View.OrderViewModel;
import com.example.coffe_shop.models.entity.Orders;
import com.example.coffe_shop.repository.OrderRepository;
import com.example.coffe_shop.service.CategoryService;
import com.example.coffe_shop.service.OrderService;
import com.example.coffe_shop.service.UserService;
import com.example.coffe_shop.util.CurrentUser;
import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel map) {
        Orders order=modelMapper.map(map, Orders.class);
        order.setUsers(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryName(map.getCategory()));

        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {

        return orderRepository.findAllByOrderByPriceDesc().stream().map(orders -> modelMapper.map(orders,OrderViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
