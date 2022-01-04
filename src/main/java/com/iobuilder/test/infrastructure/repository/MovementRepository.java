package com.iobuilder.test.infrastructure.repository;

import com.iobuilder.test.domain.movement.model.MovementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovementRepository extends CrudRepository<MovementEntity, UUID> {

    List<MovementEntity> findAllByWalletId(UUID walletId);
}
