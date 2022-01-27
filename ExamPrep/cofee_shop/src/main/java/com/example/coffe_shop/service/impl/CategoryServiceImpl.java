package com.example.coffe_shop.service.impl;

import com.example.coffe_shop.models.entity.Categories;
import com.example.coffe_shop.models.entity.enums.CategoryNameEnum;
import com.example.coffe_shop.repository.CategoryRepository;
import com.example.coffe_shop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()!=0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values()).forEach(categoryNameEnum -> {
            Categories categories=new Categories();
            categories.setName(categoryNameEnum);
            switch (categoryNameEnum){
                case CAKE->categories.setNeededTime(10);
                case DRINK->categories.setNeededTime(1);
                case COFFEE->categories.setNeededTime(2);
                case OTHER->categories.setNeededTime(5);
            }
            categoryRepository.save(categories);
        });
    }

    @Override
    public Categories findByCategoryName(CategoryNameEnum categories) {
        return categoryRepository.findByName(categories).orElse(null);
    }
}
