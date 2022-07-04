package com.casestudy.service.furama_interface.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable p);

    List<Employee> findAll();

    Employee findById(int id);

    void delete(int employeeId);

    void save(Employee employee);

    Page<Employee> findByEmployeeName(String name, Pageable p);
}
