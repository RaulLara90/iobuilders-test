package com.iobuilder.bank.application.impl;

import com.iobuilder.bank.application.DepositUseCase;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.mapper.WalletMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import com.iobuilder.bank.domain.wallet.AmountDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepositUseCaseImpl implements DepositUseCase {

    private final MovementService movementService;
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    public DepositUseCaseImpl(MovementService movementService,
                              WalletService walletService,
                              WalletMapper walletMapper) {
        this.movementService = movementService;
        this.walletService = walletService;
        this.walletMapper = walletMapper;
    }


    @Override
    public WalletDto deposit(UUID walletId, AmountDto amountDto) {
        Wallet wallet = walletService.deposit(walletId,amountDto.getAmount());
        movementService.saveDepositMovement(wallet,"D","DEPOSIT",amountDto.getAmount());
        return walletMapper.toDto(wallet);

    }
}
