package com.nc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
public class EmailExistsException extends Exception {

    public EmailExistsException(String message)
    {
        super(message);
    }
}