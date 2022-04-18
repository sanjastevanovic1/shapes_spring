package com.example.shapes.service;

import com.example.shapes.dto.ShapeDto;
import com.example.shapes.entity.Shape;
import com.example.shapes.exception.InputException;
import com.example.shapes.exception.NotFoundException;
import com.example.shapes.exception.ShapeControllerAdvice;
import com.example.shapes.mapper.ShapeMapper;
import com.example.shapes.repository.ShapeRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;


@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Optional<Shape> getShapeById(Integer id) {
        if(id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        Optional<Shape> res = shapeRepository.findById(id);
        if(res.isPresent()) {
            return res;
        } else {
            throw new NotFoundException("Shape not found. Wrong id");
        }
    }



    public List<ShapeDto> getAllShapes() {
        List<Shape> shapeList = shapeRepository.findAll();
        List<ShapeDto> shapeDtoList = ShapeMapper.toShapeDtoList(shapeList);
        return shapeDtoList;
    }

    public ShapeDto getShapeByName(String name) {
        if(shapeRepository.getByName(name) == null) {
            throw new NotFoundException("Not found shape with that name");
        }
        return ShapeMapper.toShapeDto(shapeRepository.getByName(name));
    }

    public ShapeDto createShape(Shape shape) {
        if(shape.getDimensionList().size() == 0) {
            throw new InputException("Number of dimensions cannot be 0");
        }
        ShapeDto shapeDto = ShapeMapper.toShapeDto(shapeRepository.save(shape));
        return shapeDto;
    }

    public void deleteShape(Integer id) {
        if(shapeRepository.findById(id).isPresent()) {
            shapeRepository.deleteById(id);
        } else {
            throw new NotFoundException("Cannot be deleted. There is not shape with that id");
        }
    }
    public List<ShapeDto> findAllByVolume(Double volume) {
        return ShapeMapper.toShapeDtoList(shapeRepository.getByVolume(volume));
    }

//    public List<Shape> findAllByScope(Double volume) {
//        return shapeRepository.getByScope(volume);
//    }
    public List<ShapeDto> findAllBySurface(Double volume) {
        return ShapeMapper.toShapeDtoList(shapeRepository.getBySurface(volume));
    }
    public void updateShape(Integer id, Shape shape) {
        shape.setId(id);
        shapeRepository.save(shape);
    }
    public List<ShapeDto> getTriangleByDimension(Double value){
        return ShapeMapper.toShapeDtoList(shapeRepository.getTriangleByDimension(value));
    }
}
