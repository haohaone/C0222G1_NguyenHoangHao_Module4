package com.flower.service.imp;

import com.flower.model.Flower;
import com.flower.repository.FLowerRepository;
import com.flower.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlowerServiceImp implements FlowerService {
    @Autowired
    private FLowerRepository fLowerRepository;

    @Override
    public Page<Flower> findAll(Pageable p) {
        return fLowerRepository.findAll(p);
    }

    @Override
    public Flower findByID(int id) {
        return fLowerRepository.findById(id).orElse(null);
    }
}
