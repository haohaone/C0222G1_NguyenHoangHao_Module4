package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(45)")
    private String id;

    private String name;
    private String author;

    @Column(name = "publication_date", columnDefinition = "VARCHAR(45)")
    private String publicationDate;
    private String category;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBookList;

    public Book() {
    }

    public Set<OrderBook> getOrderBookList() {
        return orderBookList;
    }

    public void setOrderBookList(Set<OrderBook> orderBookList) {
        this.orderBookList = orderBookList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
