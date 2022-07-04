package com.casestudy.service.furama_interface.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable p);

    List<Customer> findAll();

    Customer findById(String id);

    void delete(String customerId);

    void save(Customer customer);

    Page<Customer> findByCustomerName(String name, Pageable p);
}
