package com.music_web.controller;

import com.music_web.model.Music;
import com.music_web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/")
    public String showMusicList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "music-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        musicService.delete(id);
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "music-list";
    }

    @PostMapping("/search")
    public String showMusicList(@RequestParam("name") String name, Model model) {
        List<Music> musicList = musicService.searchByName(name);
        model.addAttribute("musicList", musicList);
        return "music-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "create";
        }
        musicService.save(music);
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "music-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Music music = musicService.findById(id);
        model.addAttribute("music", music);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "create";
        }
        musicService.edit(music);
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "music-list";
    }
}
