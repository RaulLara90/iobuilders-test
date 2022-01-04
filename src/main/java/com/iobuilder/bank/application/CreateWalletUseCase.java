package com.iobuilder.bank.application;

import com.iobuilder.bank.domain.wallet.model.WalletDto;

public interface CreateWalletUseCase {
    WalletDto createWallet(WalletDto walletDto);
}
