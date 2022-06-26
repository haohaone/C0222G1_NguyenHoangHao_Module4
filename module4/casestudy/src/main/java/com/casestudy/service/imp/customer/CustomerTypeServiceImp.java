package com.casestudy.service.imp.customer;

import com.casestudy.model.customer.CustomerType;
import com.casestudy.repository.furama_interface.customer.CustomerTypeRepository;
import com.casestudy.service.furama_interface.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImp implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findByCustomerTypeId(id);
    }
}
