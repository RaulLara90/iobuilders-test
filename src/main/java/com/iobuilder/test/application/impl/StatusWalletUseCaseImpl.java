package com.iobuilder.test.application.impl;

import com.iobuilder.test.application.StatusWalletUseCase;
import com.iobuilder.test.domain.movement.mapper.MovementMapper;
import com.iobuilder.test.domain.movement.model.Movement;
import com.iobuilder.test.domain.movement.service.MovementService;
import com.iobuilder.test.domain.wallet.model.WalletStatusDto;
import com.iobuilder.test.domain.wallet.service.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StatusWalletUseCaseImpl implements StatusWalletUseCase {

    private final MovementService movementService;
    private final WalletService walletService;
    private final MovementMapper movementMapper;

    public StatusWalletUseCaseImpl(MovementService movementService,
                                   WalletService walletService,
                                   MovementMapper movementMapper) {
        this.movementService = movementService;
        this.walletService = walletService;
        this.movementMapper = movementMapper;
    }

    @Override
    public WalletStatusDto getWalletStatus(UUID walletId) {
        BigDecimal balance = walletService.getBalance(walletId);
        List<Movement> movementList = movementService.getMovementsByWalletId(walletId);
        WalletStatusDto walletStatusDto = new WalletStatusDto();
        walletStatusDto.setBalance(balance);
        walletStatusDto.setMovements(movementList.parallelStream().map(movementMapper::toDto).collect(Collectors.toList()));
        return walletStatusDto;
    }
}
