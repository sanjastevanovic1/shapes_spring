package com.example.shapes.dto;

import lombok.Data;

@Data
public class ShapeDto {
    private Integer id;
    private String name;
    private Double scope;
    private Double surface;
    private Double volume;
}
