package com.library.service.imp;

import com.library.model.OrderBook;
import com.library.repository.OrderBookRepository;
import com.library.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBookServiceImp implements OrderBookService {
    @Autowired
    private OrderBookRepository orderBookRepository;

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findById(String id) {
        return orderBookRepository.findAllOrderBookId(id);
    }

    @Override
    public void delete(OrderBook orderBook) {
        orderBookRepository.delete(orderBook);
    }

    @Override
    public List<OrderBook> findAll() {
        return (List<OrderBook>) orderBookRepository.findAll();
    }
}
