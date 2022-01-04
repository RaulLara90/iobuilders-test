package com.iobuilder.bank.application;

import com.iobuilder.bank.domain.wallet.model.WalletStatusDto;

import java.util.UUID;

public interface StatusWalletUseCase {
    WalletStatusDto getWalletStatus(UUID walletId);
}
