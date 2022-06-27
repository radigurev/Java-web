package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final StyleService styleService;

    public DBInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {
            styleService.init();
    }
}
