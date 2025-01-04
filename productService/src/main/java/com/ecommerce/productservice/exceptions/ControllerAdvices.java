package com.ecommerce.productservice.exceptions;

import com.ecommerce.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundExceptions.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(
            NotFoundExceptions notFoundExceptions
    ){
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundExceptions.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}

