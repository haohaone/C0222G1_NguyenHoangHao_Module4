package com.casestudy.service.furama_interface.service;

import com.casestudy.model.service.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();

    RentType findById(int id);
}
