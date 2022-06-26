package com.casestudy.repository.furama_interface.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
    @Query(value = "SELECT * FROM customer WHERE status_delete = 0", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable p);

    @Query(value = "SELECT * FROM customer WHERE customer_id = :id", nativeQuery = true)
    Customer findByCustomerId(@Param("id") String id);

    Page<Customer> findByCustomerNameContains(String name, Pageable p);
}
