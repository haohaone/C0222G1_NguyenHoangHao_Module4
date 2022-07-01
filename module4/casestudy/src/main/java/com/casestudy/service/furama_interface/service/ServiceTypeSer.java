package com.casestudy.service.furama_interface.service;

import com.casestudy.model.service.ServiceType;

import java.util.List;

public interface ServiceTypeSer {
    List<ServiceType> findAll();

    ServiceType findById(int id);
}
