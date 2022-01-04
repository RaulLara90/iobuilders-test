package com.iobuilder.test.infrastructure.repository;

import com.iobuilder.test.domain.wallet.model.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, UUID> {

    WalletEntity findByAccountNumber(String accountNumber);
}
