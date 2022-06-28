package com.flower.service;

import com.flower.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlowerService {
    Page<Flower> findAll(Pageable p);

    Flower findByID(int id);
}
