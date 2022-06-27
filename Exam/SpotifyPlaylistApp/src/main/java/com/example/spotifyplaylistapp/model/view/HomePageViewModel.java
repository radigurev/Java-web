package com.example.spotifyplaylistapp.model.view;

public class HomePageViewModel {
    private long id;
    private String performer;
    private String title;
    private double duration;

    public String getPerformer() {
        return performer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
