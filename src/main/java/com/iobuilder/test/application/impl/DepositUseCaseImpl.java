package com.iobuilder.test.application.impl;

import com.iobuilder.test.application.DepositUseCase;
import com.iobuilder.test.domain.movement.service.MovementService;
import com.iobuilder.test.domain.wallet.mapper.WalletMapper;
import com.iobuilder.test.domain.wallet.model.Wallet;
import com.iobuilder.test.domain.wallet.model.WalletDto;
import com.iobuilder.test.domain.wallet.service.WalletService;
import com.iobuilder.test.domain.wallet.AmountDto;
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
