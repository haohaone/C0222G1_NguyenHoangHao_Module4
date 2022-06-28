package com.flower.repository;

import com.flower.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FLowerRepository extends JpaRepository<Flower, Integer> {
}
