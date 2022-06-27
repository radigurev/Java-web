package com.example.musicsite.init;

import com.example.musicsite.model.entity.enums.ArtistName;
import com.example.musicsite.service.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final ArtistService artistService;

    public DBInit(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {
            if (artistService.count()==0) {
                artistService.init();
            }
    }
}
