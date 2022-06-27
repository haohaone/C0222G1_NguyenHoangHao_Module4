package com.library.service.imp;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Page<Book> findAllBook(Pageable p) {
        return bookRepository.findAll(p);
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findBookByID(id);
    }

    @Override
    public void borrow(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
    }

    @Override
    public void giveback(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }
}
