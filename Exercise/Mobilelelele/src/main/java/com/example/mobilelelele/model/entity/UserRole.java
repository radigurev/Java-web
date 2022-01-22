package com.example.mobilelelele.model.entity;

import com.example.mobilelelele.model.entity.Enum.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private Role role;
    private List<User> user;

    public UserRole() {

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToMany(mappedBy = "roles")
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
