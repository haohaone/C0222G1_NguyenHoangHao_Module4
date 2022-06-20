package com.product.repository.imp;

import com.product.model.Product;
import com.product.repository.BaseRepository;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @Override
    public List<Product> findAll() {
        String select = "SELECT p FROM product p WHERE p.statusDelete <> 1";
        List<Product> productList = BaseRepository.entityManager.createQuery(select, Product.class).getResultList();
        return productList;
    }

    @Override
    public Product findById(String id) {
        String select = "SELECT p FROM product p WHERE p.id = ?1";
        Product product = BaseRepository.entityManager.createQuery(select, Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(String id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        product.setStatusDelete(1);
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        String select = "SELECT p FROM product p WHERE p.name LIKE ?1 AND p.statusDelete <> 1";
        List<Product> productList = BaseRepository.entityManager.createQuery(select, Product.class).
                setParameter(1, "%" + name + "%").getResultList();
        return productList;
    }
}
