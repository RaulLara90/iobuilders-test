package com.iobuilder.test.infrastructure.config.exceptions;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ErrorResponse {

    private LocalDate date;
    private String message;
    private String details;

    public ErrorResponse(LocalDate date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }
}
