package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.binding.UserAddSongBindingModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final UserService userService;
    public SongController(SongService songService, UserService userService) {
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String getAddSongsPage() {
        if(userService.userIsLogged())
            return "redirect:/";

        return "song-add";
    }

    @PostMapping("/add")
    public String saveUserSong(@Valid UserAddSongBindingModel bindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("UserAddSongBindingModel",bindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.UserAddSongBindingModel",bindingResult);
            return "redirect:/add";
        }

        songService.saveSong(bindingModel);

        return "redirect:/";
    }

    @GetMapping("/remove/playlist")
    public String removeUserPlaylist() {
        userService.removeUserPlaylist();
        return "redirect:/";
    }

    @GetMapping("/add/playlist/{id}")
    public String addToUserPlaylist(@PathVariable Long id) {
        userService.addSongToUserPlaylistById(id);
        return "redirect:/";
    }

    @ModelAttribute
    public UserAddSongBindingModel userAddSongBindingModel() {
        return new UserAddSongBindingModel();
    }
}
