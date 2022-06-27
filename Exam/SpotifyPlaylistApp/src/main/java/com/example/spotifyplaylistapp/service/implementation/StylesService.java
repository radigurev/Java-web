package com.example.spotifyplaylistapp.service.implementation;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.Styles;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StylesService implements StyleService {

    private final StyleRepository styleRepository;

    public StylesService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void init() {
        if(styleRepository.count()==0) {
            Arrays.stream(Styles.values()).forEach(styleName -> {
                Style style=new Style();
                style.setName(styleName);
                style.setDescription(String.format("Description for %s",styleName.name()));
                styleRepository.saveAndFlush(style);
            });
        }
    }

    @Override
    public Style findStyle(String style) {
        return styleRepository
                .findByName(Arrays
                        .stream(Styles.values())
                        .filter(s -> s.name().equals(style))
                        .findFirst()
                        .orElse(null));
    }
}
