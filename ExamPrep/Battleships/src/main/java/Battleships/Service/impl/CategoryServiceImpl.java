package Battleships.Service.impl;

import Battleships.Service.CategoryService;
import Battleships.models.entity.Category;
import Battleships.models.entity.enums.CategoryNameEnums;
import Battleships.repository.CategoryRepository;
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
        if(categoryRepository.count()==0){
            Arrays.stream(CategoryNameEnums.values()).forEach(categoryName -> {
                Category category = new Category(categoryName,String.format("Category description for %s",categoryName));
                categoryRepository.saveAndFlush(category);
            });
        }
    }

    @Override
    public Category findByName(CategoryNameEnums name) {
        return categoryRepository.findByName(name);
    }
}
