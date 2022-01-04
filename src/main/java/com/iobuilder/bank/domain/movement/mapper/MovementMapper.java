package com.iobuilder.bank.domain.movement.mapper;

import com.iobuilder.bank.domain.movement.model.Movement;
import com.iobuilder.bank.domain.movement.model.MovementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MovementMapper {

    public MovementDto toDto(Movement movement) {
        MovementDto movementDto = new MovementDto();
        BeanUtils.copyProperties(movement, movementDto);
        return movementDto;
    }

    public Movement toDomain(MovementDto movementDto) {
        Movement movement = new Movement();
        BeanUtils.copyProperties(movementDto, movement);
        return movement;
    }
}