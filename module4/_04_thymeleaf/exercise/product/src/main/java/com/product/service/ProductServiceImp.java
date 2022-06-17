package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private static List<Product> productList = new LinkedList<>();

    static {
        productList.add(new Product("PD-0001", "Iphone-11", 1500, "99%", "Apple"));
        productList.add(new Product("PD-0002", "Iphone-13", 4000, "100%", "Apple"));
        productList.add(new Product("PD-0003", "Iphone-XS", 1000, "99%", "Apple"));
        productList.add(new Product("PD-0004", "Samsung Note A7", 2000, "99%", "Samsung"));
        productList.add(new Product("PD-0005", "Samsung Note A9", 4000, "100%", "Samsung"));
        productList.add(new Product("PD-0006", "Xiaomi Redmi - M8", 4000, "100%", "Xiaomi"));
        productList.add(new Product("PD-0007", "Xiaomi Bluemi - M7", 3000, "99%", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(String id) {
        Product product = null;
        for (Product item : productList) {
            if (item.getId().equals(id)) {
                product = item;
                break;
            }
        }
        return product;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(Product product) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(product.getId())) {
                index = i;
                break;
            }
        }
        productList.set(index, product);
    }

    @Override
    public void delete(String id) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        productList.remove(index);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productListSearch = new LinkedList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                productListSearch.add(productList.get(i));
            }
        }
        return productListSearch;
    }
}
