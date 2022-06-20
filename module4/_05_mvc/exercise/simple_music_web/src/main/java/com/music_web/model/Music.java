package com.music_web.model;

import javax.persistence.*;

@Entity(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Integer id;
    @Column(name = "name_music")
    private String nameMusic;
    @Column(name = "name_artist")
    private String nameArtist;
    private String type;
    private String url;
    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete = 0;

    public Music() {
    }

    public Music(Integer id, String nameMusic, String nameArtist, String type, String url, Integer statusDelete) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.nameArtist = nameArtist;
        this.type = type;
        this.url = url;
        this.statusDelete = statusDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }
}
