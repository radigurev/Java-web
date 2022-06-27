package com.example.spotifyplaylistapp.service.implementation;

import com.example.spotifyplaylistapp.model.binding.UserAddSongBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.UsersSongs;
import com.example.spotifyplaylistapp.model.entity.enums.Styles;
import com.example.spotifyplaylistapp.model.view.HomePageViewModel;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SongsService implements SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleService styleService;

    public SongsService(SongRepository songRepository, ModelMapper modelMapper, StyleService styleService) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleService = styleService;
    }

    @Override
    public void saveSong(UserAddSongBindingModel bindingModel) {
        Song isPerformerTaken=songRepository.findByPerformer(bindingModel.getPerformer()).orElse(null);
        if(isPerformerTaken==null) {
            Song song = modelMapper.map(bindingModel,Song.class);
            song.setStyle(styleService.findStyle(bindingModel.getStyle()));
            songRepository.saveAndFlush(song);
//            songRepository.saveAndFlush(modelMapper.map(bindingModel,Song.class));
        }

    }

    @Override
    public List<HomePageViewModel> getSongsByStyle(Styles style) {
        List<Song> byStyle = songRepository.findByStyle(style);
        List<HomePageViewModel> homePageViewModels= new ArrayList<>();
        byStyle.forEach(s -> {
            HomePageViewModel homePageViewModel=new HomePageViewModel();
            homePageViewModel.setId(s.getId());
            homePageViewModel.setPerformer(s.getPerformer());
            homePageViewModel.setTitle(s.getTitle());
            homePageViewModel.setDuration((double) s.getDuration()/60);
            homePageViewModels.add(homePageViewModel);
        });
        return homePageViewModels;
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<HomePageViewModel> getUserPlaylist(List<UsersSongs> songsForUserPlaylist) {

        ArrayList<HomePageViewModel> songs=new ArrayList<>();
        for (UsersSongs s:
             songsForUserPlaylist) {
                HomePageViewModel homePageViewModel=new HomePageViewModel();
                homePageViewModel.setTitle(s.getSong().getTitle());
                homePageViewModel.setPerformer(s.getSong().getPerformer());
                homePageViewModel.setDuration((double) s.getSong().getDuration()/60);
                songs.add(homePageViewModel);
        }

        return songs;
    }
}
