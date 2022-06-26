package com.casestudy.service.furama_interface.customer;

import com.casestudy.model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(int id);
}
