package com.iobuilder.bank.application;

import com.iobuilder.bank.application.impl.DepositUseCaseImpl;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.AmountDto;
import com.iobuilder.bank.domain.wallet.mapper.WalletMapper;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.domain.wallet.model.WalletDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DepositUseCaseImplTest {

    @InjectMocks
    private DepositUseCaseImpl depositUseCase;
    @Mock
    private MovementService movementService;
    @Mock
    private WalletService walletService;
    @Mock
    private WalletMapper walletMapper;
    @Mock
    private AmountDto amountDto;
    @Mock
    private Wallet wallet;
    @Mock
    private WalletDto walletDto;

    private final UUID ID = UUID.randomUUID();

    @Test
    public void deposit() {
        when(walletService.deposit(any(), any())).thenReturn(wallet);
        doNothing().when(movementService).saveDepositMovement(any(), anyString(), anyString(), any());
        when(walletMapper.toDto(any())).thenReturn(walletDto);
        WalletDto res = depositUseCase.deposit(ID, amountDto);
        assertNotNull(res);
    }
}