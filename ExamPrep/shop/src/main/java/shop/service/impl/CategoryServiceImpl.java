package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.models.entity.Category;
import shop.models.entity.enums.CategoriesEnumName;
import shop.repository.CategoryRepository;
import shop.service.CategoryService;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void addCategories() {
        if(this.categoryRepository.count()==0){
            Arrays.stream(CategoriesEnumName.values()).forEach(CategoryName -> {
                Category category=new Category();
                category.setName(CategoryName);
                category.setDescription(String.format("%s description",CategoryName));
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Category findCategory(CategoriesEnumName category) {
        return categoryRepository.findByName(category).orElse(null);
    }


}
