package com.example.shapes.controller;

import com.example.shapes.entity.Dimension;
import com.example.shapes.service.DimensionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DimensionController {

    private final DimensionService dimensionService;

    public DimensionController(DimensionService dimensionService) {
        this.dimensionService = dimensionService;
    }

    @GetMapping("/dimensions")
    public List<Dimension> getAll() {
        return dimensionService.getAll();
    }


}
