package com.digicamp.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Map;

public class APIException {
    private final Map<String, String> errors;
    private final HttpStatus httpStatus;
    private String message;
    private final ZonedDateTime timeStamp;

    public APIException(String message, HttpStatus httpStatus, Map<String, String> errors, ZonedDateTime timeStamp) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.timeStamp = timeStamp;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
