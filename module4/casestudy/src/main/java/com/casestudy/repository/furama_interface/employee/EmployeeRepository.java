package com.casestudy.repository.furama_interface.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee WHERE status_delete = 0", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable p);

    @Query(value = "SELECT * FROM employee WHERE employee_id = :id", nativeQuery = true)
    Employee findByEmployeeId(@Param("id") int id);

    @Query(value = "SELECT * FROM employee WHERE status_delete = 0 AND employee_name LIKE :name", nativeQuery = true)
    Page<Employee> findByEmployeeName(@Param("name") String name, Pageable p);
}
