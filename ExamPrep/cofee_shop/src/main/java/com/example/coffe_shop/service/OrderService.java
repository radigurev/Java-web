package com.example.coffe_shop.service;

import com.example.coffe_shop.models.Service.OrderServiceModel;
import com.example.coffe_shop.models.View.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel map);

    List<OrderViewModel> findAllOrderByPriceDesc();
}
