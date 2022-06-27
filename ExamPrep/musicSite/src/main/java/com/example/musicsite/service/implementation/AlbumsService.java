package com.example.musicsite.service.implementation;

import com.example.musicsite.model.binding.AddAlbumsBindingModel;
import com.example.musicsite.model.entity.Album;
import com.example.musicsite.model.entity.enums.ArtistName;
import com.example.musicsite.repository.AlbumRepository;
import com.example.musicsite.service.AlbumService;
import com.example.musicsite.service.ArtistService;
import com.example.musicsite.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AlbumsService implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    public AlbumsService(AlbumRepository albumRepository, ArtistService artistService, UserService userService, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveAlbum(AddAlbumsBindingModel albumWrapper) {
        Album album=modelMapper.map(albumWrapper,Album.class);
        Arrays.stream(ArtistName.values()).forEach(n -> {
            if (n.name().equals(albumWrapper.getArtist()))
                album.setArtist(artistService.findByName(n));
        });
        album.setAddedFrom(userService.getCurrentUser());

        albumRepository.saveAndFlush(album);
    }
}
