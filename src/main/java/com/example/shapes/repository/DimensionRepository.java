package com.example.shapes.repository;

import com.example.shapes.entity.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimensionRepository extends JpaRepository<Dimension, Integer> {
    Dimension getByName(String name);
    Dimension getByValue(double value);
}
