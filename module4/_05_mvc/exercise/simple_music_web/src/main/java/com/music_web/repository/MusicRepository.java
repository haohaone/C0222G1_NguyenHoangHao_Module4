package com.music_web.repository;

import com.music_web.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> findAll();

    Music findById(int id);

    void save(Music music);

    void edit(Music music);

    void delete(int id);

    List<Music> searchByName(String name);
}
