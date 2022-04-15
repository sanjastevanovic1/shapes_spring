package com.example.shapes.controller;

import com.example.shapes.entity.Dimension;
import com.example.shapes.service.DimensionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DimensionController {

    private final DimensionService dimensionService;

    public DimensionController(DimensionService dimensionService) {
        this.dimensionService = dimensionService;
    }

    @GetMapping("/dimensions")
    public List<Dimension> getAll()
    {
        return dimensionService.getAll();
    }
    @GetMapping("dimensions/{id}")
    public Optional<Dimension> getDimensionById(@PathVariable("id") Integer id) {
        return dimensionService.getDimensionById(id);
    }
    @PostMapping(path = "dimensions/add")
    public Dimension createDimension(@RequestBody Dimension dimension) {
        return dimensionService.createDimension(dimension);
    }

    @DeleteMapping("/dimension/delete/{id}")
    public void deleteDimensionById(@PathVariable Integer id) {
        dimensionService.deleteDimension(id);
    }

    @PutMapping("/dimension/update/{id}")
    public void updateDimension(@PathVariable Integer id, @RequestBody Dimension dimension) {
        dimensionService.updateDimension(id,dimension);
    }
    @GetMapping("/dimensions/value/{value}")
    public List<Dimension> getAllByValue(@PathVariable("value") Double value)
    {
        return dimensionService.getByValue(value);
    }
}
