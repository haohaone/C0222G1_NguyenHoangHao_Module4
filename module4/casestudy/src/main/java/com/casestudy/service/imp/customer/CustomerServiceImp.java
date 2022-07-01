package com.casestudy.service.imp.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.furama_interface.customer.CustomerRepository;
import com.casestudy.service.furama_interface.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(Pageable p) {
        return customerRepository.findAllCustomer(p);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findByCustomerId(id);
    }

    @Override
    public void delete(String customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        customer.setStatusDelete(1);
        customerRepository.save(customer);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByCustomerName(String name, Pageable p) {
        return customerRepository.findByCustomerName("%"+name+"%", p);
    }
}
