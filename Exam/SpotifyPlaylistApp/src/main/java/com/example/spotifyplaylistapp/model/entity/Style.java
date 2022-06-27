package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.entity.enums.Styles;

import javax.persistence.*;

@Table
@Entity
public class Style extends BaseEntity {

    private Styles name;
    private String description;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    public Styles getName() {
        return name;
    }

    public void setName(Styles name) {
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
