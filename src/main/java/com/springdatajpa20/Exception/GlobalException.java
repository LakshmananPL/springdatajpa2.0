package com.springdatajpa20.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AgentsAlreadyFoundException.class)
    public ResponseEntity<Map<String, String>>
    handleAgentsAlreadyFoundException(AgentsAlreadyFoundException agentsAlreadyFoundException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", agentsAlreadyFoundException.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AgentsNotFoundException.class)
    public ResponseEntity<Map<String, String>>
    handleAgentsNotFoundException(AgentsNotFoundException agentsNotFoundException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", agentsNotFoundException.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
