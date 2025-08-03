package com.ng.api.gestao.bancaria.exception;

import com.ng.api.gestao.bancaria.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestaoBancariaExceptionHandler {

    @ExceptionHandler(GestaoBancariaException.class)
    public ResponseEntity<ErrorResponse> handleGestaoBancariaException(GestaoBancariaException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                ex.getHttpStatus().toString()
        );

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        if (ex.getHttpStatus() != null)
            httpStatus = ex.getHttpStatus();
        return ResponseEntity.status(httpStatus).body(error);
    }
}
