package com.example.musicsite.model.binding;

import com.example.musicsite.model.entity.Artist;
import com.example.musicsite.model.entity.enums.Genre;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Date;

public class AddAlbumsBindingModel {
    private String name;
    private String url;
    private BigDecimal price;
    private int copies;
    private Date releaseDate;
    private String producer;
    private String genre;
    private String artist;
    private String description;

    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Size(min = 5)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive
    @NotNull
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    @PastOrPresent
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
//    @NotNull
//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }

    @NotBlank
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @NotBlank
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
