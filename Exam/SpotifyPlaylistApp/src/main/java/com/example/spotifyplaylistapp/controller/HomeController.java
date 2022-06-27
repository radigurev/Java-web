package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.enums.Styles;
import com.example.spotifyplaylistapp.model.view.HomePageViewModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final SongService songService;
    public HomeController(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService = songService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if(userService.userIsLogged())
            return "index";

        List<HomePageViewModel> userPlaylist = userService.getUserPlaylist();
        double durationOfPlaylist=0;
        for (HomePageViewModel homePageViewModel : userPlaylist) {
            durationOfPlaylist+= homePageViewModel.getDuration();
        }

        model.addAttribute("popSongs",songService.getSongsByStyle(Styles.POP));
        model.addAttribute("rockSongs",songService.getSongsByStyle(Styles.ROCK));
        model.addAttribute("jazzSongs",songService.getSongsByStyle(Styles.JAZZ));
        model.addAttribute("userPlaylist",userPlaylist);
        model.addAttribute("durationOfPlaylist",durationOfPlaylist);
        System.out.println();
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }


}
