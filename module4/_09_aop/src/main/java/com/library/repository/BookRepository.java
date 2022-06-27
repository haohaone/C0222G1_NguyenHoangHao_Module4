package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {
    @Query(value = "FROM book WHERE id = :id")
    Book findBookByID(@Param("id") String id);
}
