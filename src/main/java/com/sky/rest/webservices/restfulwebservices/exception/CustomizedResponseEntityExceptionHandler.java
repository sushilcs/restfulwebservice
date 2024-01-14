package com.sky.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
       ErrorDetails details = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotfoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
    }


}
