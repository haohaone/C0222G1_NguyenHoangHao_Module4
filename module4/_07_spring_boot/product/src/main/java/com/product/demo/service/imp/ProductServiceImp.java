package com.product.demo.service.imp;

import com.product.demo.model.Product;
import com.product.demo.repository.ProductRepository;
import com.product.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable p) {
        return productRepository.findAll(p);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit( product.getId(),
                                product.getName(),
                                product.getPrice(),
                                product.getProductDescription(),
                                product.getProducer());
    }



    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable p) {
        return productRepository.searchByName("%"+name+"%", p);
    }
}
