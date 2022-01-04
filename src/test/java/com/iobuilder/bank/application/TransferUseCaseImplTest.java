package com.iobuilder.bank.application;

import com.iobuilder.bank.application.impl.TransferUseCaseImpl;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.TransferDto;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class TransferUseCaseImplTest {

    @InjectMocks
    private TransferUseCaseImpl transferUseCase;
    @Mock
    private MovementService movementService;
    @Mock
    private WalletService walletService;
    @Mock
    private TransferDto transferDto;
    private final String STR = "STR";
    @Mock
    private Wallet wallet;
    private UUID ID = UUID.randomUUID();


    @Test
    public void transfer() {
        when(walletService.getWallet(any())).thenReturn(wallet);
        when(walletService.getWalletByAccount(anyString())).thenReturn(wallet);
        when(wallet.getBalance()).thenReturn(BigDecimal.TEN);
        when(wallet.getAccountNumber()).thenReturn(STR);
        when(transferDto.getAmount()).thenReturn(BigDecimal.TEN);
        when(transferDto.getConcept()).thenReturn(STR);
        when(transferDto.getDestinationAccount()).thenReturn(STR);
        doNothing().when(movementService).saveTransferMovement(any(), anyString(), anyString(), any(), anyString(), anyString());
        transferUseCase.transfer(ID, transferDto);
        verify(walletService, times(1)).getWallet(any());
        verify(walletService, times(1)).getWalletByAccount(anyString());
        verify(movementService, times(2)).saveTransferMovement(any(), anyString(), anyString(), any(), anyString(), anyString());
    }

}