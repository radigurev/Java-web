package com.example.musicsite.service;

import com.example.musicsite.model.entity.Artist;
import com.example.musicsite.model.entity.enums.ArtistName;

public interface ArtistService {
    long count();

    void init();

    Artist findByName(ArtistName n);
}
