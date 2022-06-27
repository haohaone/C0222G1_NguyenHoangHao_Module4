package com.library.repository;

import com.library.model.OrderBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderBookRepository extends CrudRepository<OrderBook, String> {
    @Query(value = "FROM order_book WHERE id = :id")
    OrderBook findAllOrderBookId(@Param("id") String id);

}
