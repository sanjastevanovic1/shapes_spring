package com.example.shapes.repository;

import com.example.shapes.entity.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShapeRepository extends JpaRepository<Shape, Integer> {
    Shape getByName(String name);

//    @Query(
//            "select s from Shape s where s.name = :shape_name"
//    )
//    Shape getShape(@Param("shape_name") String shapeName);
//

    List<Shape> getByScope(Double scope);
    List<Shape> getBySurface(Double surface);
    List<Shape> getByVolume(Double volume);

}
