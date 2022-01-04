package com.iobuilder.bank.domain.movement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDto {

    private UUID id;
    private String originAccount;
    private String destinationAccount;
    private String concept;
    private String type;
    private BigDecimal amount;
    private LocalDate operationDate;
}
