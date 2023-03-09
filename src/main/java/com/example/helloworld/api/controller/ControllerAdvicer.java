package com.example.helloworld.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvicer {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handleMissingParameterException(MissingServletRequestParameterException ex) {
//        String errorMessage = ex.getParameterName() + " parameter is missing";
        String errorMessage = "Invalid Parameter";
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
