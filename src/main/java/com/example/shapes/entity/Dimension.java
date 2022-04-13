package com.example.shapes.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String name;
    double value;
    @ManyToMany(mappedBy = "dimensionList")
    List<Shape> shapeList;

    public Dimension(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public Dimension() {}

    public int getId() {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
