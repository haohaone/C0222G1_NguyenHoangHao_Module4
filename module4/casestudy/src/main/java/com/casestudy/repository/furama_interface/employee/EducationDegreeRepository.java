package com.casestudy.repository.furama_interface.employee;

import com.casestudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EducationDegreeRepository extends CrudRepository<EducationDegree, Integer> {
    @Query(value = "SELECT * FROM education_degree WHERE education_degree_id = :id", nativeQuery = true)
    EducationDegree findByEducationDegreeId(@Param("id") int id);
}
