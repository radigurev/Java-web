package com.example.musicsite.model.entity;

import com.example.musicsite.model.entity.enums.ArtistName;

import javax.persistence.*;

@Table
@Entity
public class Artist extends BaseEntity {

    private ArtistName brand;
    private String careerInformation;

    public Artist() {
    }

    public Artist(ArtistName brand, String careerInformation) {
        this.brand = brand;
        this.careerInformation = careerInformation;
    }

    @Enumerated(EnumType.STRING)
    public ArtistName getBrand() {
        return brand;
    }

    public void setBrand(ArtistName brand) {
        this.brand = brand;
    }

    @Column(columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
