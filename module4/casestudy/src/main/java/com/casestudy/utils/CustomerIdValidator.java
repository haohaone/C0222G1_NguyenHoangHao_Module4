package com.casestudy.utils;

import com.casestudy.model.customer.Customer;
import com.casestudy.repository.furama_interface.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerIdValidator implements ConstraintValidator<CheckCustomerId, String> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void initialize(CheckCustomerId checkCustomerId) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Customer customer = customerRepository.findByCustomerId(value);
        if (customer != null){
            return false;
        }else {
            return true;
        }
    }
}
