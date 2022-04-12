package com.example.shapes.repository;

import com.example.shapes.entity.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShapeRepository extends JpaRepository<Shape, Integer> {
    Shape getByName(String name);

//    @Query(
//            "select s from Shape s where s.name = :shape_name"
//    )
//    Shape getShape(@Param("shape_name") String shapeName);
//
    Shape findAllByVolume(@Param("volume") Double volume);
}
