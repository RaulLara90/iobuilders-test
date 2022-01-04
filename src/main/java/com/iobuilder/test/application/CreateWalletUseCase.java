package com.iobuilder.test.application;

import com.iobuilder.test.domain.wallet.model.WalletDto;

public interface CreateWalletUseCase {
    WalletDto createWallet(WalletDto walletDto);
}
