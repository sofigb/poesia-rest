package com.poesia.diaria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class MyException extends Exception{
    private final HttpStatus statusCode;


    public MyException(String message) {
        super(message);
        statusCode = null;
    }

    public MyException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
