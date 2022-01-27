package com.example.coffe_shop.models.Service;

import com.example.coffe_shop.models.entity.Categories;
import com.example.coffe_shop.models.entity.Users;
import com.example.coffe_shop.models.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryNameEnum category;
    private Users users;

    public OrderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
