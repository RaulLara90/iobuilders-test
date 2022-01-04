package com.iobuilder.bank.infrastructure.config.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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
