package com.example.shapes.service;

import com.example.shapes.entity.Dimension;
import com.example.shapes.entity.Shape;
import com.example.shapes.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DimensionService {

    private final DimensionRepository dimensionRepository;

    public DimensionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public Dimension getDimensionByName(String name) {
        return dimensionRepository.getByName(name);
    }
    public Dimension getByValue(double value) {
        return dimensionRepository.getByValue(value);
    }

    public List<Dimension> getAll() {
        return dimensionRepository.findAll();
    }

}
