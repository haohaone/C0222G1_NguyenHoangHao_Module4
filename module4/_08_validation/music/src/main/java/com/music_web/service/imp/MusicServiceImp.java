package com.music_web.service.imp;

import com.music_web.model.Music;
import com.music_web.repository.MusicRepository;
import com.music_web.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImp implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void edit(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }

    @Override
    public List<Music> searchByName(String name) {
        return musicRepository.findByName("%" + name + "%");
    }
}
