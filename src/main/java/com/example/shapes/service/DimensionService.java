package com.example.shapes.service;

import com.example.shapes.dto.DimensionDto;
import com.example.shapes.entity.Dimension;
import com.example.shapes.exception.NotFoundException;
import com.example.shapes.mapper.DimensionMapper;
import com.example.shapes.repository.DimensionRepository;
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
        if(dim == null) {
            throw new NotFoundException("There is no dimension with that name");
        }
        DimensionDto dimensionDto = DimensionMapper.toDimensionDto(dim);
        return dimensionDto;
    }
    public List<DimensionDto> getByValue(double value) {
        List<Dimension> dimensionList = dimensionRepository.getByValue(value);
        if(dimensionList.size() == 0) {
            throw new NotFoundException("Not found any dimension with that value");
        }
        return DimensionMapper.dimensionListToDtoList(dimensionList);
    }

    public List<DimensionDto> getAll() {
        List<Dimension> dimensionList = dimensionRepository.findAll();
        if(dimensionList.size() == 0) {
            throw new NotFoundException("There are no dimensions in database");
        }
        return DimensionMapper.dimensionListToDtoList(dimensionList);
    }

    public DimensionDto createDimension(Dimension dimension) {
        return DimensionMapper.toDimensionDto(dimensionRepository.save(dimension));
    }
    public void deleteDimension(Integer id) {
        dimensionRepository.deleteById(id);
    }

    public Optional<Dimension> getDimensionById(Integer id) {
        return dimensionRepository.findById(id);
    }
    public void updateDimension(DimensionDto dimensionDto) {

        dimensionRepository.save(DimensionMapper.toDimension(dimensionDto));
    }
}
