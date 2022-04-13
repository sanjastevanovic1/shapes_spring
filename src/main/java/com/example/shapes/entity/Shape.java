package com.example.shapes.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shape {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double scope;
    private Double surface;
    private Double volume;
    @ManyToMany
    @JoinTable(
            name="shape_dimension",
            joinColumns = @JoinColumn(name="dimension_id"),
            inverseJoinColumns = @JoinColumn(name = "shape_id")
    )
    List<Dimension> dimensionList;
    public Shape(String name, Double scope, Double surface, Double volume) {
        this.name = name;
        this.scope = scope;
        this.surface = surface;
        this.volume = volume;
    }

    public Shape() {}


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScope() {
        return scope;
    }

    public void setScope(Double scope) {
        this.scope = scope;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scope=" + scope +
                ", surface=" + surface +
                ", volume=" + volume +
                '}';
    }
}
