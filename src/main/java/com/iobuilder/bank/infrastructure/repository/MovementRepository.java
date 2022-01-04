package com.iobuilder.bank.infrastructure.repository;

import com.iobuilder.bank.domain.movement.model.MovementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovementRepository extends CrudRepository<MovementEntity, UUID> {

    List<MovementEntity> findAllByWalletId(UUID walletId);
}
