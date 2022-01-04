package com.iobuilder.bank.domain.wallet.service.impl;

import com.iobuilder.bank.domain.wallet.mapper.WalletEntityMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletEntity;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import com.iobuilder.bank.infrastructure.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletEntityMapper walletEntityMapper;

    public WalletServiceImpl(WalletRepository walletRepository, WalletEntityMapper walletEntityMapper) {
        this.walletRepository = walletRepository;
        this.walletEntityMapper = walletEntityMapper;
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletEntityMapper.toDomain(walletRepository.save(walletEntityMapper.toEntity(wallet)));
    }

    @Override
    public Wallet getWallet(UUID walletId) {
        return walletEntityMapper.toDomain(walletRepository.findById(walletId).get());
    }

    @Override
    public Wallet getWalletByAccount(String accountNumber) {
        return walletEntityMapper.toDomain(walletRepository.findByAccountNumber(accountNumber));
    }

    @Override
    public BigDecimal getBalance(UUID walletId) {
        WalletEntity wallet = walletRepository.findById(walletId).get();
        return wallet.getBalance();
    }

    @Override
    public Wallet deposit(UUID walletId, BigDecimal amount) {
        WalletEntity wallet = walletRepository.findById(walletId).get();
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);
        return walletEntityMapper.toDomain(wallet);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletEntityMapper.toDomain(walletRepository.save(walletEntityMapper.toEntity(wallet)));
    }
}
