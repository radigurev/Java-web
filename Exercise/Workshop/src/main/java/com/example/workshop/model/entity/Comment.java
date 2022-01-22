package com.example.workshop.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    private Boolean approved;
    private String textContent;
    private road route;
    private UserEntity author;
    private LocalDateTime created;

    public Comment() {
    }
    @Column(nullable = false)
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    @Column(name = "text_content",columnDefinition = "TEXT")
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
    @Column(nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @ManyToOne
    public road getRoute() {
        return route;
    }

    public void setRoute(road route) {
        this.route = route;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
