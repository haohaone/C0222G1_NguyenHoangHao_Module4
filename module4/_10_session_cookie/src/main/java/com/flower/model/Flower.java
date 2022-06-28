package com.flower.model;

import javax.persistence.*;

@Entity(name = "flower")
public class Flower {
    @Id
    private Integer id;

    private String name;
    private Integer price;

    @Column(name = "img_url")
    private String imgUrl;

    public Flower() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
