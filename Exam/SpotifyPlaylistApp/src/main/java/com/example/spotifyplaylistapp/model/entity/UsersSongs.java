package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_songs")
public class UsersSongs extends BaseEntity{

    private Song song;

    private User user;

    @ManyToOne
    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
