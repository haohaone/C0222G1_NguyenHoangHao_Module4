package com.casestudy.service.furama_interface.employee;

import com.casestudy.model.employee.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();

    Division findById(int id);
}
