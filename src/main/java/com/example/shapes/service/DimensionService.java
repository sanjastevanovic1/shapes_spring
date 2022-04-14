package com.example.shapes.service;

import com.example.shapes.entity.Dimension;
import com.example.shapes.repository.DimensionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DimensionService {

    private final DimensionRepository dimensionRepository;

    public DimensionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public Dimension getDimensionByName(String name) {
        return dimensionRepository.getByName(name);
    }
    public List<Dimension> getByValue(double value) {
        return dimensionRepository.getByValue(value);
    }

    public List<Dimension> getAll() {
        return dimensionRepository.findAll();
    }

    public Dimension createDimension(Dimension dimension) {
        return dimensionRepository.save(dimension);
    }
    public void deleteDimension(Integer id) {
        dimensionRepository.deleteById(id);
    }

    public Optional<Dimension> getDimensionById(Integer id) {
        return dimensionRepository.findById(id);
    }
    public void updateDimension(Integer id, Dimension dimension) {
        dimension.setId(id);
        dimensionRepository.save(dimension);
    }
}
