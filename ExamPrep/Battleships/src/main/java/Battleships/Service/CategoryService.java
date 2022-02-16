package Battleships.Service;

import Battleships.models.entity.Category;
import Battleships.models.entity.enums.CategoryNameEnums;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryNameEnums name);
}
