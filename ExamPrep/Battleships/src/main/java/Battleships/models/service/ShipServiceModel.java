package Battleships.models.service;

import Battleships.models.entity.enums.CategoryNameEnums;

import java.util.Date;

public class ShipServiceModel {
    private String name;
    private long power;
    private long health;
    private Date created;
    private CategoryNameEnums category;

    public ShipServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public CategoryNameEnums getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnums category) {
        this.category = category;
    }
}
