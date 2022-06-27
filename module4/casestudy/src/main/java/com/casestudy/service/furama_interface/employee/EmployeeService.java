package com.casestudy.service.furama_interface.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable p);

    Employee findById(int id);

    void delete(int employeeId);

    void save(Employee employee);

    Page<Employee> findByEmployeeName(String name, Pageable p);
}
