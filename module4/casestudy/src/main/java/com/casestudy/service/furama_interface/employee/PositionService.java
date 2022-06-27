package com.casestudy.service.furama_interface.employee;

import com.casestudy.model.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    Position findById(int id);
}
