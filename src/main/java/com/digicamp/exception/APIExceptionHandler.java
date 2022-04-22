package com.digicamp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                 HttpHeaders headers, HttpStatus status, WebRequest request){
       Map<String, String> errors = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error) -> {
           String name = ((FieldError) error).getField();
           String message = error.getDefaultMessage();
           errors.put(name, message);
       });

       APIException exception = new APIException("Validation failed", HttpStatus.BAD_REQUEST, errors, ZonedDateTime.now(ZoneId.of("Z")));
       return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
   }

    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(APIRequestException e){
        Map<String, String> errors = new HashMap<>();
        APIException apiException = new APIException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                errors,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                    HttpStatus status, WebRequest request) {
        System.out.println(ex);
        APIException apiException = new APIException(
                "Invalid request body",
                HttpStatus.BAD_REQUEST,
                new HashMap<>(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = {Throwable.class})
//    public ResponseEntity<Object> defaultException(Throwable ex) {
//        APIException apiException = new APIException(
//                "Invalid request body",
//                HttpStatus.BAD_REQUEST,
//                new HashMap<>(),
//                ZonedDateTime.now(ZoneId.of("Z"))
//        );
//        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
//    }
}
