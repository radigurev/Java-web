package com.example.workshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String title,url;
    private UserEntity author;
    private road route;

    public Picture() {
    }
    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(nullable = false,columnDefinition = "TEXT")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @ManyToOne
    public road getRoute() {
        return route;
    }

    public void setRoute(road route) {
        this.route = route;
    }
}
