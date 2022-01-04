package com.iobuilder.test.application.impl;

import com.iobuilder.test.application.TransferUseCase;
import com.iobuilder.test.domain.movement.service.MovementService;
import com.iobuilder.test.domain.wallet.mapper.WalletMapper;
import com.iobuilder.test.domain.wallet.model.Wallet;
import com.iobuilder.test.domain.wallet.service.WalletService;
import com.iobuilder.test.domain.wallet.TransferDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferUseCaseImpl implements TransferUseCase {

    private final MovementService movementService;
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    public TransferUseCaseImpl(MovementService movementService,
                               WalletService walletService,
                               WalletMapper walletMapper) {
        this.movementService = movementService;
        this.walletService = walletService;
        this.walletMapper = walletMapper;
    }

    @Override
    public void transfer(UUID walletId, TransferDto transferDto) {
        Wallet originWallet = walletService.getWallet(walletId);
        originWallet.setBalance(originWallet.getBalance().subtract(transferDto.getAmount()));
        movementService.saveTransferMovement(originWallet,"T",transferDto.getConcept(),transferDto.getAmount(),
                originWallet.getAccountNumber(),transferDto.getDestinationAccount());
        walletService.save(originWallet);

        Wallet destinationWallet = walletService.getWalletByAccount(transferDto.getDestinationAccount());
        destinationWallet.setBalance(destinationWallet.getBalance().add(transferDto.getAmount()));
        movementService.saveTransferMovement(destinationWallet,"T",transferDto.getConcept(),transferDto.getAmount(),
                transferDto.getDestinationAccount(),originWallet.getAccountNumber());
        walletService.save(destinationWallet);
    }
}
