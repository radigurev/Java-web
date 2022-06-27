package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.view.HomePageViewModel;

import java.util.List;

public interface UserService
{
    boolean userIsLogged();

    boolean registerUser(UserRegisterBindingModel bindingModel);

    User findUser(UserLoginBindingModel bindingModel);

    void loginUser(User user);

    void addSongToUserPlaylistById(Long id);

    List<HomePageViewModel> getUserPlaylist();

    void removeUserPlaylist();
}
