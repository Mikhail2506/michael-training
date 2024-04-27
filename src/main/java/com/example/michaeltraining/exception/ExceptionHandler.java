package com.example.michaeltraining.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorApi> handleException(NotFoundException exception) {
        ErrorApi userError = new ErrorApi();
        userError.setInfo(exception.getMessage());
        return new ResponseEntity<>(userError, HttpStatus.NOT_FOUND);

    }
}