package com.example.michaeltraining.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorApi> handleException(NotFoundException exception) {
        ErrorApi message = new ErrorApi();
        message.setInfo(exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }
}