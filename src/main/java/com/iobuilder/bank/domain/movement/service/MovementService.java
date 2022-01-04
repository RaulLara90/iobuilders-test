package com.iobuilder.bank.domain.movement.service;

import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.wallet.model.Wallet;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface MovementService {

    List<Movement> getMovementsByWalletId(UUID walletId);
    void saveDepositMovement(Wallet wallet, String type, String concept, BigDecimal amount);
    void saveTransferMovement(Wallet wallet, String type, String concept, BigDecimal amount, String originAccount, String destinationAccount);
}
