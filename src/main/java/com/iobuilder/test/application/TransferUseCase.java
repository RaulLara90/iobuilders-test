package com.iobuilder.test.application;

import com.iobuilder.test.domain.wallet.TransferDto;

import java.util.UUID;

public interface TransferUseCase {
    void transfer(UUID walletId, TransferDto transferDto);
}
