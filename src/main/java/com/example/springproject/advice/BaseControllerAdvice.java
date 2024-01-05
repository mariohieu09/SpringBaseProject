package com.example.springproject.advice;

import com.example.springproject.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BaseControllerAdvice {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFoundException(Exception ex, WebRequest request){
        return ErrorMessage.builder()
                .statusCode(404)
                .message(ex.getMessage())
                .build();
    }
}
