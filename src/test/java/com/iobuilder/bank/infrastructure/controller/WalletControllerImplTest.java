package com.iobuilder.bank.infrastructure.controller;

import com.iobuilder.bank.application.CreateWalletUseCase;
import com.iobuilder.bank.application.DepositUseCase;
import com.iobuilder.bank.application.StatusWalletUseCase;
import com.iobuilder.bank.application.TransferUseCase;
import com.iobuilder.bank.domain.wallet.AmountDto;
import com.iobuilder.bank.domain.wallet.TransferDto;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.model.WalletStatusDto;
import com.iobuilder.bank.infrastructure.contoller.impl.WalletControllerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class WalletControllerImplTest {

    @InjectMocks
    private WalletControllerImpl walletController;
    @Mock
    private StatusWalletUseCase statusWalletUseCase;
    @Mock
    private DepositUseCase depositUseCase;
    @Mock
    private CreateWalletUseCase createWalletUseCase;
    @Mock
    private TransferUseCase transferUseCase;
    @Mock
    private WalletDto walletDto;
    @Mock
    private WalletStatusDto walletStatusDto;
    @Mock
    private TransferDto transferDto;
    @Mock
    private AmountDto amountDto;
    private UUID ID = UUID.randomUUID();


    @Test
    public void createWallet() {
        when(createWalletUseCase.createWallet(any())).thenReturn(walletDto);
        ResponseEntity<WalletDto> res = walletController.createWallet(walletDto);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
    }

    @Test
    public void getWalletStatus() {
        when(statusWalletUseCase.getWalletStatus(any(UUID.class))).thenReturn(walletStatusDto);
        ResponseEntity<WalletStatusDto> res = walletController.getWalletStatus(ID);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
    }

    @Test
    public void deposit() {
        when(depositUseCase.deposit(any(UUID.class), any(AmountDto.class))).thenReturn(walletDto);
        ResponseEntity<WalletDto> res = walletController.deposit(ID, amountDto);
        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertNotNull(res.getBody());
    }

    @Test
    public void transfer() {
        doNothing().when(transferUseCase).transfer(any(UUID.class), any(TransferDto.class));
        ResponseEntity<WalletDto> res = walletController.transfer(ID, transferDto);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }
}