package com.iobuilder.bank.application;

import com.iobuilder.bank.application.impl.StatusWalletUseCaseImpl;
import com.iobuilder.bank.domain.movement.mapper.MovementMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementDto;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.model.WalletStatusDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StatusWalletUseCaseImplTest {

    @InjectMocks
    private StatusWalletUseCaseImpl statusWalletUseCase;
    @Mock
    private MovementService movementService;
    @Mock
    private WalletService walletService;
    @Mock
    private MovementMapper movementMapper;
    @Mock
    private MovementDto movementDto;
    @Mock
    private Movement movement;
    private UUID ID = UUID.randomUUID();


    @Test
    public void transfer() {
        when(walletService.getBalance(any())).thenReturn(BigDecimal.TEN);
        when(movementService.getMovementsByWalletId(any())).thenReturn(Collections.singletonList(movement));
        when(movementMapper.toDto(any())).thenReturn(movementDto);
        WalletStatusDto res = statusWalletUseCase.getWalletStatus(ID);
        assertNotNull(res);
    }

}