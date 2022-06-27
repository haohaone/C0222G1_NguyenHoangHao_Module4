package com.casestudy.repository.furama_interface.employee;

import com.casestudy.model.employee.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PositionRepository extends CrudRepository<Position, Integer> {
    @Query(value = "SELECT * FROM `position` WHERE education_degree_id = :id", nativeQuery = true)
    Position findByPositionId(@Param("id") int id);
}
