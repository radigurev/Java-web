package com.example.coffe_shop.models.View;

import com.example.coffe_shop.models.entity.Categories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Categories category;

    public OrderViewModel() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
