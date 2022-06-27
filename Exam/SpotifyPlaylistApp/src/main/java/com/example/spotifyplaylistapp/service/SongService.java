package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.UserAddSongBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.UsersSongs;
import com.example.spotifyplaylistapp.model.entity.enums.Styles;
import com.example.spotifyplaylistapp.model.view.HomePageViewModel;

import java.util.ArrayList;
import java.util.List;

public interface SongService {
    void saveSong(UserAddSongBindingModel bindingModel);

    List<HomePageViewModel> getSongsByStyle(Styles style);

    Song getSongById(Long id);

    ArrayList<HomePageViewModel> getUserPlaylist(List<UsersSongs> songsForUserPlaylist);
}
