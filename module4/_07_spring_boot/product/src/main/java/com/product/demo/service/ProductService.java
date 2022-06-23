package com.product.demo.service;

import com.product.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Page<Product> findAll(Pageable p);

    Product findById(String id);

    void save(Product product);

    void edit(Product product);

    void delete(String id);

    Page<Product> searchByName(String name, Pageable p);
}
