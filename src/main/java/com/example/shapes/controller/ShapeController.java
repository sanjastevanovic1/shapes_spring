package com.example.shapes.controller;

import com.example.shapes.entity.Shape;
import com.example.shapes.service.ShapeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

//    @GetMapping(path = "/shapes")
//    public List<Shape> getShapes() {
//        return shapeService.getAllShapes();
//    }

    @GetMapping("/shapes")
    public String getShapes(Model model) {
        model.addAttribute("shapes", shapeService.getAllShapes());
        return "shapes";
    }

    @PostMapping(path = "shapes/add")
    @ResponseBody
    public Shape createShape(@RequestBody Shape shape) {
        return shapeService.createShape(shape);
    }

    @GetMapping("shapes/{id}")
    public Optional<Shape> getShapeById(@PathVariable("id") Integer id) {
        return shapeService.getShapeById(id);
    }

    @GetMapping("shapes/name/{name}")
    public Shape getShapeByName(@PathVariable("name") String name) {
        return shapeService.getShapeByName(name);
    }

    @DeleteMapping("/shapes/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        shapeService.deleteShape(id);
    }

    @PutMapping("shape/update/{id}")
    public void updateShape(@PathVariable Integer id, @RequestBody Shape shape) {
        shapeService.updateShape(id, shape);
    }
}
