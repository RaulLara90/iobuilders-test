package com.iobuilder.test.application;

import com.iobuilder.test.domain.wallet.model.WalletDto;
import com.iobuilder.test.domain.wallet.AmountDto;

import java.util.UUID;

public interface DepositUseCase {
    WalletDto deposit(UUID walletId, AmountDto amountDto);
}
