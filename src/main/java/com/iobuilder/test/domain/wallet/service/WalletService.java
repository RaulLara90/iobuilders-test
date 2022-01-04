package com.iobuilder.test.domain.wallet.service;

import com.iobuilder.test.domain.wallet.model.Wallet;
import com.iobuilder.test.domain.wallet.model.WalletEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {

    Wallet createWallet(Wallet wallet);
    Wallet getWallet(UUID walletId);
    Wallet getWalletByAccount(String accountNumber);
    BigDecimal getBalance(UUID walletId);
    Wallet deposit(UUID walletId, BigDecimal amount);
    Wallet save(Wallet wallet);

}
