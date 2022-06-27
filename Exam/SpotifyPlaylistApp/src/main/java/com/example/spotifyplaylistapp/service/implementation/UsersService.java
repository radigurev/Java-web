package com.example.spotifyplaylistapp.service.implementation;

import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.UsersSongs;
import com.example.spotifyplaylistapp.model.view.HomePageViewModel;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.repository.UsersSongsRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UserService {

        private final CurrentUser currentUser;
        private final ModelMapper modelMapper;
        private final UserRepository userRepository;
        private final SongService songService;
        private final UsersSongsRepository usersSongsRepository;

    public UsersService(CurrentUser currentUser, ModelMapper modelMapper, UserRepository userRepository, SongService songService, UsersSongsRepository usersSongsRepository) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.songService = songService;
        this.usersSongsRepository = usersSongsRepository;
    }

    @Override
    public boolean userIsLogged() {

        return currentUser.getId()==null;
    }

    @Override
    public boolean registerUser(UserRegisterBindingModel bindingModel) {
        User byEmail=userRepository.findByEmail(bindingModel.getEmail()).orElse(null);
        User byUsername=userRepository.findByUsername(bindingModel.getUsername()).orElse(null);
        if(byEmail!=null || byUsername!=null) {
            return false;
        }
            userRepository.saveAndFlush(modelMapper.map(bindingModel,User.class));
            return true;
    }

    @Override
    public User findUser(UserLoginBindingModel bindingModel) {
        return userRepository.findUserByUsernameAndPassword(bindingModel.getUsername(), bindingModel.getPassword()).orElse(null);
    }

    @Override
    public void loginUser(User user) {
        currentUser.setUsername(user.getUsername());
        currentUser.setId(user.getId());
    }

    @Override
    public void addSongToUserPlaylistById(Long id) {
        UsersSongs usersSongs=new UsersSongs();
        usersSongs.setUser(userRepository.findById(currentUser.getId()).orElse(null));
        usersSongs.setSong(songService.getSongById(id));
        usersSongsRepository.save(usersSongs);
    }

    @Override
    public List<HomePageViewModel> getUserPlaylist() {
        return songService.getUserPlaylist(usersSongsRepository.findByUser(userRepository.findById(currentUser.getId()).orElse(null)));
    }

    @Override
    public void removeUserPlaylist() {
        usersSongsRepository.deleteAllByUser(userRepository.findById(currentUser.getId()).orElse(null));
    }
}
