package com.casestudy.repository.furama_interface.employee;

import com.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DivisionRepository extends CrudRepository<Division, Integer> {
    @Query(value = "SELECT * FROM division WHERE division_id = :id", nativeQuery = true)
    Division findByDivisionId(@Param("id") int id);
}
