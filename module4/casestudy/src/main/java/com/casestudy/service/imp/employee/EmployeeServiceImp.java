package com.casestudy.service.imp.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.furama_interface.employee.EmployeeRepository;
import com.casestudy.service.furama_interface.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable p) {
        return employeeRepository.findAllEmployee(p);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public void delete(int employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        employee.setStatusDelete(1);
        employeeRepository.save(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findByEmployeeName(String name, Pageable p) {
        return employeeRepository.findByEmployeeNameContains(name, p);
    }
}
