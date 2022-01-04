package com.iobuilder.bank.application;

import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.AmountDto;

import java.util.UUID;

public interface DepositUseCase {
    WalletDto deposit(UUID walletId, AmountDto amountDto);
}
