package com.example.mobilelelele.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity{
    private String username;
    private String password;
    private boolean isActive;
    private List<UserRole> roles;
    public User() {
    }
    @ManyToMany
    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
