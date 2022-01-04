package com.iobuilder.test.domain.wallet.service.impl;

import com.iobuilder.test.domain.wallet.mapper.WalletEntityMapper;
import com.iobuilder.test.domain.wallet.model.Wallet;
import com.iobuilder.test.domain.wallet.service.WalletService;
import com.iobuilder.test.infrastructure.repository.WalletRepository;
import org.springframework.stereotype.Service;

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
}
