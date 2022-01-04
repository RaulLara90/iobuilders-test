package com.iobuilder.bank.application;

import com.iobuilder.bank.domain.wallet.TransferDto;

import java.util.UUID;

public interface TransferUseCase {
    void transfer(UUID walletId, TransferDto transferDto);
}
