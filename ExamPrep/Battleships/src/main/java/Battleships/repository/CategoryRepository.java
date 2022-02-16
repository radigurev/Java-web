package Battleships.repository;

import Battleships.models.entity.Category;
import Battleships.models.entity.enums.CategoryNameEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryNameEnums name);
}
