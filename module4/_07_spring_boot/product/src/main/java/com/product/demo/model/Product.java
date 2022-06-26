package com.product.demo.model;

import com.product.demo.utils.CheckDoubleConstraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity(name = "product")
public class Product {
    @Id
    @Pattern(regexp = "PD-[0-9]{4}", message = "Nhập sai định dạng")
    private String id;
    @NotEmpty(message = "Không được để trống")
    private String name;

    @Column(columnDefinition = "DOUBLE")
    @CheckDoubleConstraint
    private String price;
    
    @Column(name = "product_description")
    @NotEmpty(message = "Không được để trống")
    private String productDescription;

    @NotEmpty(message = "Không được để trống")
    private String producer;

    @Column(name = "status_delete", columnDefinition = "BIT(1)")
    private Integer statusDelete = 0;

    public Product() {
    }

    public Product(@Pattern(regexp = "PD-[0-9]{4}", message = "Nhập sai định dạng") String id,
                   @NotEmpty(message = "Không được để trống") String name,
                   String price,
                   @NotEmpty(message = "Không được để trống") String productDescription,
                   @NotEmpty(message = "Không được để trống") String producer,
                   Integer statusDelete) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.producer = producer;
        this.statusDelete = statusDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }
}
