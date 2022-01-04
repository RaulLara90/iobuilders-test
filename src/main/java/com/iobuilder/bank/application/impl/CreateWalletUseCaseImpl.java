package com.iobuilder.bank.application.impl;

import com.iobuilder.bank.application.CreateWalletUseCase;
import com.iobuilder.bank.domain.wallet.mapper.WalletMapper;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final WalletService walletService;
    private final WalletMapper walletMapper;

    public CreateWalletUseCaseImpl(WalletService walletService,
                                   WalletMapper walletMapper) {
        this.walletService = walletService;
        this.walletMapper = walletMapper;
    }


    @Override
    public WalletDto createWallet(WalletDto walletDto) {
        return walletMapper.toDto(walletService.createWallet(walletMapper.toDomain(walletDto)));
    }
}
