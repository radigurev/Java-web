package Battleships.models.entity;

import Battleships.models.entity.enums.CategoryNameEnums;

import javax.persistence.*;

@Table
@Entity(name = "category")
public class Category extends BaseEntity{
    private CategoryNameEnums name;
    private String description;

    public Category() {
    }

    public Category(CategoryNameEnums categoryName, String description) {
        this.setName(categoryName);
        this.setDescription(description);
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnums getName() {
        return name;
    }

    public void setName(CategoryNameEnums name) {
        this.name = name;
    }
    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
