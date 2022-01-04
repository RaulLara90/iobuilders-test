package com.iobuilder.bank.application.impl;

import com.iobuilder.bank.application.TransferUseCase;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.TransferDto;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferUseCaseImpl implements TransferUseCase {

    private final MovementService movementService;
    private final WalletService walletService;

    public TransferUseCaseImpl(MovementService movementService,
                               WalletService walletService) {
        this.movementService = movementService;
        this.walletService = walletService;
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
