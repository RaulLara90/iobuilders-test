package com.iobuilder.bank.domain.movement.service.impl;

import com.iobuilder.bank.domain.movement.mapper.MovementEntityMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementEntity;
import com.iobuilder.bank.domain.movement.service.MovementService;
import com.iobuilder.bank.domain.wallet.model.Wallet;
import com.iobuilder.bank.infrastructure.repository.MovementRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;
    private final MovementEntityMapper movementEntityMapper;

    public MovementServiceImpl(MovementRepository movementRepository,
                               MovementEntityMapper movementEntityMapper) {
        this.movementRepository = movementRepository;
        this.movementEntityMapper = movementEntityMapper;
    }

    @Override
    public List<Movement> getMovementsByWalletId(UUID walletId) {
        List<MovementEntity> movementEntities = movementRepository.findAllByWalletId(walletId);
        if(movementEntities.isEmpty()){
            return Collections.emptyList();
        }
        return movementEntities.parallelStream().map(movementEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void saveDepositMovement(Wallet wallet, String type, String concept, BigDecimal amount) {
        Movement movement = new Movement();
        movement.setAmount(amount);
        movement.setConcept(concept);
        movement.setDestinationAccount(wallet.getAccountNumber());
        movement.setType(type);
        movement.setOperationDate(LocalDate.now());
        movement.setWalletId(wallet.getId());
        movementRepository.save(movementEntityMapper.toEntity(movement));
    }

    @Override
    public void saveTransferMovement(Wallet wallet, String type, String concept, BigDecimal amount, String originAccount, String destinationAccount) {
        Movement movement = new Movement();
        movement.setAmount(amount);
        movement.setConcept(concept);
        movement.setOriginAccount(originAccount);
        movement.setDestinationAccount(destinationAccount);
        movement.setType(type);
        movement.setOperationDate(LocalDate.now());
        movement.setWalletId(wallet.getId());
        movementRepository.save(movementEntityMapper.toEntity(movement));
    }
}
