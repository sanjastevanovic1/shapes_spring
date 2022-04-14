package com.example.shapes.repository;

import com.example.shapes.entity.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DimensionRepository extends JpaRepository<Dimension, Integer> {
    Dimension getByName(String name);
    List<Dimension> getByValue(Double value);
}
