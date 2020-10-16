package com.example.auto24backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCarMarkException extends RuntimeException {

    public InvalidCarMarkException() {

    }

    public InvalidCarMarkException(String message) {
        super(message);
    }


}
