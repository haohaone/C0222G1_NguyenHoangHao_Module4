package com.music_web.repository.imp;

import com.music_web.model.Music;
import com.music_web.repository.BaseRepository;
import com.music_web.repository.MusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepositoryImp implements MusicRepository {
    @Override
    public List<Music> findAll() {
        String select = "SELECT m FROM music m WHERE m.statusDelete <> 1";
        List<Music> musicList = BaseRepository.entityManager.createQuery(select, Music.class).getResultList();
        return musicList;
    }

    @Override
    public Music findById(int id) {
        String select = "SELECT m FROM music m WHERE m.id = ?1";
        Music music = BaseRepository.entityManager.createQuery(select, Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void edit(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = findById(id);
        music.setStatusDelete(1);
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> searchByName(String name) {
        String select = "SELECT m FROM music m WHERE m.nameMusic LIKE ?1 AND m.statusDelete <> 1";
        List<Music> musicList = BaseRepository.entityManager.createQuery(select, Music.class).
                setParameter(1, "%" + name + "%").getResultList();
        return musicList;
    }
}
