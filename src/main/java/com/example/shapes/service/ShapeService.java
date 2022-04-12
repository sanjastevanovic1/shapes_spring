package com.example.shapes.service;

import com.example.shapes.entity.Shape;
import com.example.shapes.repository.ShapeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Shape getShapeById(Integer id) {
        return shapeRepository.getById(id);
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

    public Shape findAllByVolume(double volume) {
        return shapeRepository.findAllByVolume(volume);
    }


}
