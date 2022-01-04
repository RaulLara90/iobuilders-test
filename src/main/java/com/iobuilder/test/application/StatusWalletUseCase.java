package com.iobuilder.test.application;

import com.iobuilder.test.domain.wallet.model.WalletStatusDto;

import java.util.UUID;

public interface StatusWalletUseCase {
    WalletStatusDto getWalletStatus(UUID walletId);
}
