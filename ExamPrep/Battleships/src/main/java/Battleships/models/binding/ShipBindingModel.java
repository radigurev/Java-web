package Battleships.models.binding;

import Battleships.models.entity.enums.CategoryNameEnums;
import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShipBindingModel {
    private String name;
    private long power;
    private long health;
    private Date created;
    private CategoryNameEnums category;

    public ShipBindingModel() {
    }

    @NotNull
    @Size(min = 2,max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    @Positive
    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }
    @NotNull
    @Positive
    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @NotNull
    public CategoryNameEnums getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnums category) {
        this.category = category;
    }
}
