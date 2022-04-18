package com.example.shapes.service;

import com.example.shapes.dto.DimensionDto;
import com.example.shapes.entity.Dimension;
import com.example.shapes.mapper.DimensionMapper;
import com.example.shapes.repository.DimensionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DimensionService {

    private final DimensionRepository dimensionRepository;

    public DimensionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public DimensionDto getDimensionByName(String name) {
        Dimension dim = dimensionRepository.getByName(name);
        DimensionDto dimensionDto = DimensionMapper.toDimensionDto(dim);
        return dimensionDto;
    }
    public List<DimensionDto> getByValue(double value) {
        List<Dimension> dimensionList = dimensionRepository.getByValue(value);
        return DimensionMapper.dimensionListToDtoList(dimensionList);
    }

    public List<DimensionDto> getAll() {
        List<Dimension> dimensionList = dimensionRepository.findAll();
        return DimensionMapper.dimensionListToDtoList(dimensionList);
    }

    public Dimension createDimension(Dimension dimension) {
        return dimensionRepository.save(dimension);
    }
    public void deleteDimension(Integer id) {
        dimensionRepository.deleteById(id);
    }

    public Optional<Dimension> getDimensionById(Integer id) {
        return dimensionRepository.findById(id);
    }
    public void updateDimension(Integer id, Dimension dimension) {
        dimension.setId(id);
        dimensionRepository.save(dimension);
    }
}
