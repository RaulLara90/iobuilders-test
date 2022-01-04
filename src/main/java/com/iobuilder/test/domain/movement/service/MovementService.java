package com.iobuilder.test.domain.movement.service;

import com.iobuilder.test.domain.movement.model.Movement;
import com.iobuilder.test.domain.wallet.model.Wallet;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface MovementService {

    List<Movement> getMovementsByWalletId(UUID walletId);
    void saveDepositMovement(Wallet wallet, String type, String concept, BigDecimal amount);
    void saveWithdrawMovement(Wallet wallet, String type, String concept, BigDecimal amount);
    void saveTransferMovement(Wallet wallet, String type, String concept, BigDecimal amount, String originAccount, String destinationAccount);
}
