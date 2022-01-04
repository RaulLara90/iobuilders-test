package com.iobuilder.test.infrastructure.contoller.impl;

import com.iobuilder.test.application.CreateWalletUseCase;
import com.iobuilder.test.domain.wallet.model.WalletDto;
import com.iobuilder.test.infrastructure.contoller.WalletController;
import com.iobuilder.test.infrastructure.dto.AmountDto;
import com.iobuilder.test.infrastructure.dto.TransferDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class WalletControllerImpl implements WalletController {

    private final CreateWalletUseCase createWalletUseCase;

    public WalletControllerImpl(CreateWalletUseCase createWalletUseCase) {
        this.createWalletUseCase = createWalletUseCase;
    }

    @Override
    public ResponseEntity<WalletDto> createWallet(WalletDto walletDto) {
        return new ResponseEntity<>(createWalletUseCase.createWallet(walletDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WalletDto> getWallet(UUID walletId) {
        return null;
    }

    @Override
    public ResponseEntity<WalletDto> deposit(UUID walletId, AmountDto amountDto) {
        return null;
    }

    @Override
    public ResponseEntity<WalletDto> transfer(UUID walletId, TransferDto transferDto) {
        return null;
    }
}
