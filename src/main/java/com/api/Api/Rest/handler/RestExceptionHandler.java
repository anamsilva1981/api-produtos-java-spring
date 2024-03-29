package com.api.Api.Rest.handler;

import com.api.Api.Rest.model.error.ErrorMessage;
import com.api.Api.Rest.model.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex ){

        ErrorMessage error = new ErrorMessage("Not Found",
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
