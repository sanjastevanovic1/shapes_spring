package com.example.shapes.mapper;

import com.example.shapes.dto.DimensionDto;
import com.example.shapes.dto.ShapeDto;
import com.example.shapes.entity.Shape;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeMapper {

    public static ShapeDto toShapeDto(Shape shape) {
        if(shape == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        ShapeDto shapeDto = modelMapper.map(shape, ShapeDto.class);
        return shapeDto;
    }

    public static List<ShapeDto> toShapeDtoList(List<Shape> shapeList) {
        if(CollectionUtils.isEmpty(shapeList)) {
            return Collections.emptyList();
        }
        List<ShapeDto> shapeDtoList = new ArrayList<>();
        shapeList.forEach(dimension -> {
            shapeDtoList.add(toShapeDto(dimension));
        });
        return shapeDtoList;
    }
}
