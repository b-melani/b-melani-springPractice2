package com.flow.practice2.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationException extends Exception {

    private HttpStatus httpStatus;
    public ValidationException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }
    public ValidationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
