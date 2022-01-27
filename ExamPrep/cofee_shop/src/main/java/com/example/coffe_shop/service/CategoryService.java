package com.example.coffe_shop.service;

import com.example.coffe_shop.models.entity.Categories;
import com.example.coffe_shop.models.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Categories findByCategoryName(CategoryNameEnum categories);
}
