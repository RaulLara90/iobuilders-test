package com.iobuilder.bank.infrastructure.config;

import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import com.iobuilder.bank.infrastructure.config.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> getResponseForConflictException(ConflictException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorDetails(request, ex.getMessage()), HttpStatus.CONFLICT);
    }

    private ErrorResponse getErrorDetails(WebRequest request, String message) {
        return new ErrorResponse(LocalDate.now(), message, request.getDescription(false));
    }
}
