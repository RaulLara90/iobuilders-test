package com.iobuilder.bank.domain.wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {

    private BigDecimal amount;
    private String destinationAccount;
    private String concept;
}
