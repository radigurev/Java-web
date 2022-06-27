package com.example.spotifyplaylistapp.model.entity;


import javax.persistence.*;
import java.util.Set;

@Table
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;


    @Column(unique = true,nullable = false)
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
    @Column(unique = true,nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
