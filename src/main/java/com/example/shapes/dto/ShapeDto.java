package com.example.shapes.dto;

import com.example.shapes.entity.Dimension;
import lombok.Data;

import java.util.List;

@Data
public class ShapeDto {
    private Integer id;
    private String name;
    private Double scope;
    private Double surface;
    private Double volume;
    private List<Dimension> dimensionList;

}
