package com.example.shapes.service;

import com.example.shapes.entity.Dimension;
import com.example.shapes.entity.Shape;
import com.example.shapes.repository.ShapeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Optional<Shape> getShapeById(Integer id) {
        return shapeRepository.findById(id);
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }

    public Shape getShapeByName(String name) {
        return shapeRepository.getByName(name);
    }

    public Shape createShape(Shape shape) {
        return shapeRepository.save(shape);
    }

    public void deleteShape(Integer id) {
        shapeRepository.deleteById(id);
    }
    public List<Shape> findAllByVolume(Double volume) {
        return shapeRepository.getByVolume(volume);
    }

    public List<Shape> findAllByScope(Double volume) {
        return shapeRepository.getByScope(volume);
    }
    public List<Shape> findAllBySurface(Double volume) {
        return shapeRepository.getBySurface(volume);
    }
    public void updateShape(Integer id, Shape shape) {
        shape.setId(id);
        shapeRepository.save(shape);
    }

}
