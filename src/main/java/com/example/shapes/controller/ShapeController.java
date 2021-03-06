package com.example.shapes.controller;

import com.example.shapes.dto.ShapeDto;
import com.example.shapes.entity.Shape;
import com.example.shapes.service.ShapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShapeController {

    private final ShapeService shapeService;


    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }


    @GetMapping(path = "/shapes")
    public ResponseEntity<List<ShapeDto>> getShapes() {
        return new ResponseEntity<>(shapeService.getAllShapes(), HttpStatus.OK);
    }


    @PostMapping(path = "shapes/add")
    public ShapeDto createShape(@RequestBody Shape shape) {
        return shapeService.createShape(shape);
    }

    @GetMapping("shapes/{id}")
    public Optional<Shape> getShapeById(@PathVariable("id") Integer id) {
        return shapeService.getShapeById(id);
    }

    @GetMapping("shapes/name/{name}")
    public ShapeDto getShapeByName(@PathVariable("name") String name) {
        return shapeService.getShapeByName(name);
    }

    @DeleteMapping("/shapes/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        shapeService.deleteShape(id);
    }

    @PutMapping("shape/update")
    public void updateShape(@RequestBody ShapeDto shapeDto) {
        shapeService.updateShape(shapeDto);
    }

    @GetMapping("shapes/volume/{value}")
    public List<ShapeDto> getByVolume(@PathVariable("value") Double value) {
        return shapeService.findAllByVolume(value);
    }

//    @GetMapping("shapes/scope/{value}")
//    public List<Shape> getByScope(@PathVariable("value") Double value) {
//        return shapeService.findAllByScope(value);
//    }

    @GetMapping("shapes/surface/{value}")
    public ResponseEntity<List<ShapeDto>> getBySurface(@PathVariable("value") Double value) {

        return new ResponseEntity<>(shapeService.findAllBySurface(value), HttpStatus.ACCEPTED);
    }

    @GetMapping("shapes/dimension/{value}")
    public ResponseEntity<List<ShapeDto>> getShapeByDimesnion(@PathVariable("value") Double value) {

        return new ResponseEntity<>(shapeService.getTriangleByDimension(value), HttpStatus.OK);
    }
}
