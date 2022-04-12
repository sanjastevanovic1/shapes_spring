package com.example.shapes.controller;

import com.example.shapes.entity.Shape;
import com.example.shapes.service.ShapeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping(path = "/shapes")
    public List<Shape> getShapes() {
        return shapeService.getAllShapes();
    }


    @PostMapping("/add")
    public Shape createShape(Shape shape) {
        return shapeService.createShape(shape);
    }

    @GetMapping("shapes/{id}")
    public Shape getShapeById(@PathVariable("id") int id) {
        return shapeService.getShapeById(id);
    }


}
