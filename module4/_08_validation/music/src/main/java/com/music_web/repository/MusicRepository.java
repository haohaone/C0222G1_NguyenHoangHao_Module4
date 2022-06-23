package com.music_web.repository;

import com.music_web.model.Music;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface MusicRepository extends PagingAndSortingRepository<Music, Integer> {

    @Modifying
    @Query(value = "UPDATE music SET statusDelete = 1 WHERE id = :id")
    void delete(@Param("id") int id);

    @Query(value = "FROM music WHERE statusDelete = 0 AND nameMusic like :name")
    List<Music> findByName(@Param("name") String name);

    @Query(value = "FROM music WHERE statusDelete = 0")
    List<Music> findAll();
}
