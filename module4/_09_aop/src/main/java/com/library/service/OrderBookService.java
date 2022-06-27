package com.library.service;

import com.library.model.OrderBook;

import java.util.List;

public interface OrderBookService {
    void save(OrderBook orderBook);

    OrderBook findById(String id);

    void delete(OrderBook orderBook);

    List<OrderBook> findAll();
}
