package com.iobuilder.bank.domain.movement;

import com.iobuilder.bank.domain.movement.mapper.MovementEntityMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class MovementEntityMapperTest {

    @InjectMocks
    private MovementEntityMapper movementEntityMapper;
    private MovementEntity movementEntity;
    private Movement movement;

    @BeforeEach
    public void init() {

        String STR = "STR";
        LocalDate date = LocalDate.now();
        UUID ID = UUID.randomUUID();
        movement = new Movement();
        movement.setAmount(BigDecimal.ONE);
        movement.setConcept(STR);
        movement.setDestinationAccount(STR);
        movement.setId(ID);
        movement.setOperationDate(date);
        movement.setOriginAccount(STR);
        movement.setType(STR);
        movementEntity = new MovementEntity();
        movementEntity.setAmount(BigDecimal.ONE);
        movementEntity.setConcept(STR);
        movementEntity.setDestinationAccount(STR);
        movementEntity.setId(ID);
        movementEntity.setOperationDate(date);
        movementEntity.setOriginAccount(STR);
        movementEntity.setType(STR);

    }

    @Test
    public void toDomain() {
        Movement movement = movementEntityMapper.toDomain(movementEntity);
        assertNotNull(movement);
        assertEquals(movement.getAmount(), movementEntity.getAmount());
        assertEquals(movement.getConcept(), movementEntity.getConcept());
        assertEquals(movement.getDestinationAccount(), movementEntity.getDestinationAccount());
        assertEquals(movement.getId(), movementEntity.getId());
        assertEquals(movement.getOperationDate(), movementEntity.getOperationDate());
        assertEquals(movement.getOriginAccount(), movementEntity.getOriginAccount());
        assertEquals(movement.getType(), movementEntity.getType());
    }

    @Test
    public void toEntity() {
        MovementEntity movementEntity = movementEntityMapper.toEntity(movement);
        assertNotNull(movement);
        assertEquals(movement.getAmount(), movementEntity.getAmount());
        assertEquals(movement.getConcept(), movementEntity.getConcept());
        assertEquals(movement.getDestinationAccount(), movementEntity.getDestinationAccount());
        assertEquals(movement.getId(), movementEntity.getId());
        assertEquals(movement.getOperationDate(), movementEntity.getOperationDate());
        assertEquals(movement.getOriginAccount(), movementEntity.getOriginAccount());
        assertEquals(movement.getType(), movementEntity.getType());
    }
}
