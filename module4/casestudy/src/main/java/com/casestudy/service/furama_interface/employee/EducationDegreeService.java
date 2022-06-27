package com.casestudy.service.furama_interface.employee;

import com.casestudy.model.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(int id);
}
