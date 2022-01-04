package com.iobuilder.bank.domain.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {

    private UUID id;
    private UUID ownerId;
    private String accountNumber;
    private BigDecimal balance;
}
