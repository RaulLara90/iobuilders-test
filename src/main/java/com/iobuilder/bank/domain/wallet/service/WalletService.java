package com.iobuilder.bank.domain.wallet.service;

import com.iobuilder.bank.domain.wallet.model.Wallet;

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
