package com.library.service;

import com.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAllBook(Pageable p);

    Book findById(String id);

    void borrow(Book book);

    void giveback(Book book);
}
