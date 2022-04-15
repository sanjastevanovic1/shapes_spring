package com.example.shapes.service;

import com.example.shapes.entity.Shape;
import com.example.shapes.repository.ShapeRepository;
import org.springframework.stereotype.Service;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;


@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Optional<Shape> getShapeById(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        Optional<Shape> res = shapeRepository.findById(id);
//        if(res.isPresent()) {
//            return res;
//        }
        return res;
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }

    public Shape getShapeByName(String name) {
        return shapeRepository.getByName(name);
    }

    public Shape createShape(Shape shape) {
        if(shape.getDimensionList().size() == 0) {
            throw new InputMismatchException("Number of dimensions cannot be 0");
        }
        return shapeRepository.save(shape);
    }

    public void deleteShape(Integer id) {
        shapeRepository.deleteById(id);
    }
    public List<Shape> findAllByVolume(Double volume) {
        return shapeRepository.getByVolume(volume);
    }

//    public List<Shape> findAllByScope(Double volume) {
//        return shapeRepository.getByScope(volume);
//    }
    public List<Shape> findAllBySurface(Double volume) {
        return shapeRepository.getBySurface(volume);
    }
    public void updateShape(Integer id, Shape shape) {
        shape.setId(id);
        shapeRepository.save(shape);
    }
    public List<Shape> getTriangleByDimension(Double value){
        return shapeRepository.getTriangleByDimension(value);
    }
}
