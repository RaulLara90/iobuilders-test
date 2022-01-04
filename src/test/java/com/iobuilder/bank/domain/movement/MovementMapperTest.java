package com.iobuilder.bank.domain.movement;

import com.iobuilder.bank.domain.movement.mapper.MovementMapper;
import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class MovementMapperTest {

    @InjectMocks
    private MovementMapper movementMapper;
    private MovementDto movementDto;
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
        movementDto = new MovementDto();
        movementDto.setAmount(BigDecimal.ONE);
        movementDto.setConcept(STR);
        movementDto.setDestinationAccount(STR);
        movementDto.setId(ID);
        movementDto.setOperationDate(date);
        movementDto.setOriginAccount(STR);
        movementDto.setType(STR);

    }

    @Test
    public void toDomain() {
        Movement movement = movementMapper.toDomain(movementDto);
        assertNotNull(movement);
        assertEquals(movement.getAmount(), movementDto.getAmount());
        assertEquals(movement.getConcept(), movementDto.getConcept());
        assertEquals(movement.getDestinationAccount(), movementDto.getDestinationAccount());
        assertEquals(movement.getId(), movementDto.getId());
        assertEquals(movement.getOperationDate(), movementDto.getOperationDate());
        assertEquals(movement.getOriginAccount(), movementDto.getOriginAccount());
        assertEquals(movement.getType(), movementDto.getType());
    }

    @Test
    public void toDto() {
        MovementDto movementDto = movementMapper.toDto(movement);
        assertNotNull(movement);
        assertEquals(movement.getAmount(), movementDto.getAmount());
        assertEquals(movement.getConcept(), movementDto.getConcept());
        assertEquals(movement.getDestinationAccount(), movementDto.getDestinationAccount());
        assertEquals(movement.getId(), movementDto.getId());
        assertEquals(movement.getOperationDate(), movementDto.getOperationDate());
        assertEquals(movement.getOriginAccount(), movementDto.getOriginAccount());
        assertEquals(movement.getType(), movementDto.getType());
    }
}
