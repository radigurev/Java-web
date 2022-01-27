package com.example.coffe_shop.repository;

import com.example.coffe_shop.models.entity.Categories;
import com.example.coffe_shop.models.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Long> {
    Optional<Categories> findByName(CategoryNameEnum nameEnum);
}
