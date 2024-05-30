package com.camdyn.simplebankingapp.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorResponseExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest req) throws Exception {
        ApiError error = new ApiError(ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @ExceptionHandler(UserNotFoundException.class)
    // public final ResponseEntity<ApiError> handleUserNotFoundException(Exception ex, WebRequest req) {
    //     ApiError error = new ApiError(ex.getMessage(), req.getDescription(false));
    //     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    // }
}
