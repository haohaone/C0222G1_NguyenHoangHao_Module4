package com.casestudy.service.imp.employee;

import com.casestudy.model.employee.Position;
import com.casestudy.repository.furama_interface.employee.PositionRepository;
import com.casestudy.service.furama_interface.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImp implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findByPositionId(id);
    }
}
