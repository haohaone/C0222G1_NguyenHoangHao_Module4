package com.casestudy.service.imp.employee;

import com.casestudy.model.employee.Division;
import com.casestudy.repository.furama_interface.employee.DivisionRepository;
import com.casestudy.service.furama_interface.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImp implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return (List<Division>) divisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findByDivisionId(id);
    }
}
