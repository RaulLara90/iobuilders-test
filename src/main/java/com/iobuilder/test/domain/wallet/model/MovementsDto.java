package com.iobuilder.test.domain.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementsDto {

    private BigDecimal amount;
    private String type;
    private String originAccount;
    private String destinationAccount;
    private String concept;
}
