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

//    @Query (
//            "SELECT s FROM Shape s " +
//                    "WHERE s.name = :scope"
//    )
 //   List<Shape> getByScope(@Param("scope") Double scope);
    List<Shape> getBySurface(Double surface);
    List<Shape> getByVolume(Double volume);


    @Query("SELECT s FROM Shape s JOIN s.dimensionList d WHERE d.value = :value AND s.name='Triangle'")
    List<Shape> getTriangleByDimension(@Param("value") Double value);


    @Query("SELECT s FROM Shape s JOIN s.dimensionList d WHERE d.value > :value")
    List<Shape> getGreaterThanValue(@Param("value") Double value);
}
