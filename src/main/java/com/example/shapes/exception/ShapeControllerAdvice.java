package com.example.shapes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ShapeControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleShapeNotFoundException(NotFoundException e) {
        logger.error(e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputException.class)
    public ResponseEntity<Object> handleInputException(InputException e) {
        logger.error(e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
