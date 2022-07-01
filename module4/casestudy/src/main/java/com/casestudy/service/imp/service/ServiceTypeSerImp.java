package com.casestudy.service.imp.service;

import com.casestudy.model.service.ServiceType;
import com.casestudy.repository.furama_interface.service.ServiceTypeRepository;
import com.casestudy.service.furama_interface.service.ServiceTypeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeSerImp implements ServiceTypeSer {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
