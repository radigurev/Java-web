package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;

public interface StyleService {

    void init();

    Style findStyle(String style);
}
