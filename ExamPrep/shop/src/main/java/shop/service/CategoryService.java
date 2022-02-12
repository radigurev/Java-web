package shop.service;

import shop.models.entity.Category;
import shop.models.entity.enums.CategoriesEnumName;

public interface CategoryService {
    void addCategories();

    Category findCategory(CategoriesEnumName category);
}
