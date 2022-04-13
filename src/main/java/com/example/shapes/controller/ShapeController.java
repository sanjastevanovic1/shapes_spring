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


    @PostMapping(path = "shapes/add")
    @ResponseBody
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.createShape(shape);
    }

    @GetMapping("shapes/{id}")
    public Shape getShapeById(@PathVariable("id") Integer id) {
        return shapeService.getShapeById(id);
    }

    @GetMapping("shapes/name/{name}")
    public Shape getShapeByName(@PathVariable("name") String name) {
        return shapeService.getShapeByName(name);
    }

}
