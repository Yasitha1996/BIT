package com.rest.restAPI.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exceptions extends RuntimeException{

    public Exceptions(String msg){
        super(msg);
    }
}
