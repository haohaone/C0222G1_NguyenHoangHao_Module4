package com.casestudy.repository.furama_interface.customer;

import com.casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {

    @Query(value = "SELECT * FROM customer_type WHERE customer_type_id = :id", nativeQuery = true)
    CustomerType findByCustomerTypeId(@Param("id") int id);
}
