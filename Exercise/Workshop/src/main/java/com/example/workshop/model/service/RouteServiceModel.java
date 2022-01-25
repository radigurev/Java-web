package com.example.workshop.model.service;

import com.example.workshop.model.entity.Category;
import com.example.workshop.model.entity.Picture;
import com.example.workshop.model.entity.UserEntity;
import com.example.workshop.model.entity.enums.LevelEnum;

import java.util.Set;

public class RouteServiceModel extends BaseServiceModel{
    private LevelEnum levelEnum;
    private String name;
    private String gpxCoordinates;
    private String videoUrl;
    private UserEntity author;
    private String description;
    private Set<Picture> pictures;
    private Set<Category> categories;

    public RouteServiceModel() {
    }

    public LevelEnum getLevelEnum() {
        return levelEnum;
    }

    public void setLevelEnum(LevelEnum levelEnum) {
        this.levelEnum = levelEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
