package com.iobuilder.bank.domain.movement;

import com.iobuilder.bank.domain.movement.mapper.MovementEntityMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementEntity;
import com.iobuilder.bank.domain.movement.service.impl.MovementServiceImpl;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.infrastructure.repository.MovementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class MovementServiceImplTest {

    @InjectMocks
    private MovementServiceImpl movementService;
    @Mock
    private MovementRepository movementRepository;
    @Mock
    private MovementEntityMapper movementEntityMapper;
    @Mock
    private MovementEntity movementEntity;
    @Mock
    private Movement movement;
    @Mock
    private Wallet wallet;
    private final UUID ID = UUID.randomUUID();
    private final String STR = "STR";

    @Test
    public void getMovementsByWalletId() {
        when(movementRepository.findAllByWalletId(any())).thenReturn(Collections.singletonList(movementEntity));
        when(movementEntityMapper.toDomain(any())).thenReturn(movement);
        List<Movement> res = movementService.getMovementsByWalletId(ID);
        assertNotNull(res);
    }

    @Test
    public void getMovementsByWalletIdEmpty() {
        when(movementRepository.findAllByWalletId(any())).thenReturn(Collections.emptyList());
        List<Movement> res = movementService.getMovementsByWalletId(ID);
        assertTrue(res.isEmpty());
    }

    @Test
    public void saveDepositMovement() {
        when(movementRepository.save(any())).thenReturn(movementEntity);
        movementService.saveDepositMovement(wallet, STR, STR, BigDecimal.ONE);
        verify(movementRepository, times(1)).save(any());
    }

    @Test
    public void saveTransferMovement() {
        when(movementRepository.save(any())).thenReturn(movementEntity);
        movementService.saveTransferMovement(wallet, STR, STR, BigDecimal.ONE, STR, STR);
        verify(movementRepository, times(1)).save(any());
    }
}
