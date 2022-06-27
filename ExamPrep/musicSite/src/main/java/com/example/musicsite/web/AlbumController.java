package com.example.musicsite.web;

import com.example.musicsite.model.binding.AddAlbumsBindingModel;
import com.example.musicsite.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @ModelAttribute
    public AddAlbumsBindingModel addAlbumsBindingModel() {
        return new AddAlbumsBindingModel();
    }

    @GetMapping("/add")
    public String addAlbumsPage() {
        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbums(@Valid AddAlbumsBindingModel album, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("albumAddBindingModel", album)
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);

            return "redirect:add";
        }

        albumService.saveAlbum(album);

        return "redirect:/";
    }
}
