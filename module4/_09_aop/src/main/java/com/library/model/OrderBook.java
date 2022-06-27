package com.library.model;

import javax.persistence.*;

@Entity(name = "order_book")
public class OrderBook {
    @Id
    private String id;

    @Column(name = "borrow_date", columnDefinition = "DATE")
    private String borrowDate;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public OrderBook() {
    }

    public OrderBook(String id, String borrowDate, Book book) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
