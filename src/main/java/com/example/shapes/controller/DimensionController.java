package com.example.shapes.controller;

import com.example.shapes.dto.DimensionDto;
import com.example.shapes.entity.Dimension;
import com.example.shapes.mapper.DimensionMapper;
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
    public List<DimensionDto> getAll()
    {
        return dimensionService.getAll();
    }

    @GetMapping("dimensions/{id}")
    public Optional<Dimension> getDimensionById(@PathVariable("id") Integer id) {
        Optional<Dimension> dimension = dimensionService.getDimensionById(id);

        return dimensionService.getDimensionById(id);
    }

    @GetMapping("/dimensions/value/{value}")
    public List<DimensionDto> getAllByValue(@PathVariable("value") Double value)
    {
        return dimensionService.getByValue(value);
    }

    @PostMapping(path = "dimensions/add")
    public DimensionDto createDimension(@RequestBody Dimension dimension) {

        Dimension dim = dimensionService.createDimension(dimension);
        return DimensionMapper.toDimensionDto(dim);
    }

    @PutMapping("/dimension/update/{id}")
    public void updateDimension(@PathVariable Integer id, @RequestBody Dimension dimension) {
        dimensionService.updateDimension(id,dimension);
    }

    @DeleteMapping("/dimension/delete/{id}")
    public void deleteDimensionById(@PathVariable Integer id) {
        dimensionService.deleteDimension(id);
    }
}
