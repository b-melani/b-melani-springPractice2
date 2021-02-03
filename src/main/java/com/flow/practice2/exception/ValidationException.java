package com.flow.practice2.exception;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationException extends RuntimeException {

    public int validationException() {
        return Response.SC_BAD_REQUEST;
    }
}
