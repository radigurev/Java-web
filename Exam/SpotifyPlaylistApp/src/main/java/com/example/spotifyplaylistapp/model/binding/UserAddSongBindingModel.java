package com.example.spotifyplaylistapp.model.binding;

import com.example.spotifyplaylistapp.model.entity.Style;

import javax.validation.constraints.*;
import java.sql.Date;

public class UserAddSongBindingModel {
    private String performer;
    private String title;
    private Integer duration;
    private Date releaseDate;
    private String style;

    @Size(min = 3, max = 20,message = "Ugabugaaa")
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }
    @Size(min = 2, max = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Positive
    @NotNull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @PastOrPresent
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NotBlank
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
