package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(String id);

    void save(Product product);

    void edit(Product product);

    void delete(String id);

    List<Product> searchByName(String name);
}
