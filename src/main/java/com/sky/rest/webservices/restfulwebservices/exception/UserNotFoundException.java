package com.sky.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    private String meassage;

        public UserNotFoundException(String message){
        super(message);
        this.meassage = message;
    }
}
