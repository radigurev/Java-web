package shop.models.binding;

import org.springframework.format.annotation.DateTimeFormat;
import shop.models.entity.enums.CategoriesEnumName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoriesEnumName category;

    public ProductAddBindingModel() {
    }
    @NotBlank(message = "Cannot be empty")
    @Size(min = 3,max = 20,message = "Should be between 3-20")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Size(min = 5, message = "Description must be min 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date cannot be in the past!")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }
    @DecimalMin(value = "0",message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @NotNull(message = "You must select the category")
    public CategoriesEnumName getCategory() {
        return category;
    }

    public void setCategory(CategoriesEnumName category) {
        this.category = category;
    }
}
