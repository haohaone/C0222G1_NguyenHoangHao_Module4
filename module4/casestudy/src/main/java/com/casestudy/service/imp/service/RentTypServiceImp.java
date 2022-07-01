package com.casestudy.service.imp.service;

import com.casestudy.model.service.RentType;
import com.casestudy.repository.furama_interface.service.RentTypeRepository;
import com.casestudy.service.furama_interface.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypServiceImp implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return (List<RentType>) rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
