package com.iobuilder.bank.infrastructure.contoller.impl;

import com.iobuilder.bank.application.CreateWalletUseCase;
import com.iobuilder.bank.application.DepositUseCase;
import com.iobuilder.bank.application.StatusWalletUseCase;
import com.iobuilder.bank.application.TransferUseCase;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.model.WalletStatusDto;
import com.iobuilder.bank.infrastructure.contoller.WalletController;
import com.iobuilder.bank.domain.wallet.AmountDto;
import com.iobuilder.bank.domain.wallet.TransferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class WalletControllerImpl implements WalletController {

    private final CreateWalletUseCase createWalletUseCase;
    private final StatusWalletUseCase statusWalletUseCase;
    private final DepositUseCase depositUseCase;
    private final TransferUseCase transferUseCase;

    public WalletControllerImpl(CreateWalletUseCase createWalletUseCase,
                                StatusWalletUseCase statusWalletUseCase,
                                DepositUseCase depositUseCase,
                                TransferUseCase transferUseCase) {
        this.createWalletUseCase = createWalletUseCase;
        this.statusWalletUseCase = statusWalletUseCase;
        this.depositUseCase = depositUseCase;
        this.transferUseCase = transferUseCase;
    }

    @Override
    public ResponseEntity<WalletDto> createWallet(WalletDto walletDto) {
        return new ResponseEntity<>(createWalletUseCase.createWallet(walletDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletStatusDto> getWalletStatus(UUID walletId) {
        return new ResponseEntity<>(statusWalletUseCase.getWalletStatus(walletId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletDto> deposit(UUID walletId, AmountDto amountDto) {
        return new ResponseEntity<>(depositUseCase.deposit(walletId, amountDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletDto> transfer(UUID walletId, TransferDto transferDto) {
        transferUseCase.transfer(walletId,transferDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
