package com.example.shapes.mapper;

import com.example.shapes.dto.DimensionDto;
import com.example.shapes.entity.Dimension;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DimensionMapper {
    public static DimensionDto toDimensionDto(Dimension dimension) {
        if(dimension == null) {
            return null;
        }
        DimensionDto dto = new DimensionDto();
        dto.setId(dimension.getId());
        dto.setName(dimension.getName());
        dto.setValue(dimension.getValue());
        return dto;
    }

    public static List<DimensionDto> dimensionListToDtoList(List<Dimension> dimensionList) {
        if(CollectionUtils.isEmpty(dimensionList)) {
            return Collections.emptyList();
        }
        List<DimensionDto> dimensionDtoList = new ArrayList<>();
        dimensionList.forEach(dimension -> {
            dimensionDtoList.add(toDimensionDto(dimension));
        });
        return dimensionDtoList;
    }

    public static Dimension toDimension(DimensionDto dimensionDto) {
        if(dimensionDto == null) {
            return null;
        }
        Dimension dimension = new Dimension();
        dimension.setId(dimensionDto.getId());
        dimension.setName(dimensionDto.getName());
        dimension.setValue(dimensionDto.getValue());

        return dimension;
    }
}
