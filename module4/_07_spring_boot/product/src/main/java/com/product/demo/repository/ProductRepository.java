package com.product.demo.repository;

import com.product.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE status_delete <> 1", nativeQuery = true)
    List<Product> findAll();

    @Query(value = "SELECT * FROM product WHERE status_delete <> 1", nativeQuery = true)
    Page<Product> findAll(Pageable p);

    @Query(value = "SELECT * FROM product WHERE id = :id", nativeQuery = true)
    Product findById(@Param("id") String id);

    @Modifying
    @Query(value = "UPDATE product SET" +
            " name = :name," +
            " price = :price," +
            " product_description = :productDescription," +
            " producer = :producer WHERE id = :id", nativeQuery = true)
    void edit(@Param("id") String id,
              @Param("name") String name,
              @Param("price") String price,
              @Param("productDescription") String description,
              @Param("producer") String producer);

    @Modifying
    @Query(value = "INSERT INTO product value (:id, :name, :price, :productDescription, :producer)", nativeQuery = true)
    void save(@Param("id") String id,
              @Param("name") String name,
              @Param("price") double price,
              @Param("productDescription") String description,
              @Param("producer") String producer);

    @Modifying
    @Query(value = "UPDATE product SET status_delete = 1 WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") String id);

    @Query(value = "SELECT * FROM product WHERE status_delete <> 1 AND name LIKE :name", nativeQuery = true)
    Page<Product> searchByName(@Param("name") String name, Pageable p);
}
