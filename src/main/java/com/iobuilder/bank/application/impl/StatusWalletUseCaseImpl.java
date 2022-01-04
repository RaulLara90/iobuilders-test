package com.iobuilder.bank.application.impl;

import com.iobuilder.bank.application.StatusWalletUseCase;
import com.iobuilder.bank.domain.movement.mapper.MovementMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.model.WalletStatusDto;
import com.iobuilder.bank.domain.wallet.service.WalletService;
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
