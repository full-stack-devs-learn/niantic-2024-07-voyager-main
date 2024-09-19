package com.niantic.controllers.apis;

import com.niantic.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGlobalException(Exception ex, WebRequest request)
    {
        if(ex instanceof ErrorResponse && ((ErrorResponse)ex).getStatusCode() == HttpStatus.NOT_FOUND)
        {
            // all 404 errors
            Error body = new Error(HttpStatus.NOT_FOUND);
            body.setMessage("The requested resource was not found");

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        else
        {
            // all other errors
            Error body = new Error(HttpStatus.INTERNAL_SERVER_ERROR);
            body.setMessage(ex.getMessage());

            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
