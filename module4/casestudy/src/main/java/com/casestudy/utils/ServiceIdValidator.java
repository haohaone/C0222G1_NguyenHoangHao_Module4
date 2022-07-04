package com.casestudy.utils;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Service;
import com.casestudy.repository.furama_interface.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ServiceIdValidator implements ConstraintValidator<CheckServiceId, String> {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void initialize(CheckServiceId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Service service = serviceRepository.findById(value).orElse(null);
        if (service != null){
            return false;
        }else {
            return true;
        }
    }
}
