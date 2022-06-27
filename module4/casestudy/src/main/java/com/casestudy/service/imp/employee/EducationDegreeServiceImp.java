package com.casestudy.service.imp.employee;

import com.casestudy.model.employee.EducationDegree;
import com.casestudy.repository.furama_interface.employee.EducationDegreeRepository;
import com.casestudy.service.furama_interface.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImp implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return (List<EducationDegree>) educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepository.findByEducationDegreeId(id);
    }
}
