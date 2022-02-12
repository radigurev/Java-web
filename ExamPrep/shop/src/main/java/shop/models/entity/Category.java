package shop.models.entity;

import shop.models.entity.enums.CategoriesEnumName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoriesEnumName name;
    private String description;

    public Category() {
    }
    @Column
    @Enumerated(EnumType.STRING)
    public CategoriesEnumName getName() {
        return name;
    }

    public void setName(CategoriesEnumName name) {
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
