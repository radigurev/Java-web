package com.example.workshop.model.entity;

import com.example.workshop.model.entity.enums.RoleName;

import javax.persistence.*;
import javax.persistence.EnumType;


@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    private RoleName roleName;
    public Role() {
    }
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
