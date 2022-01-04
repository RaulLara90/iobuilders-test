package com.iobuilder.test.domain.movement.mapper;

import com.iobuilder.test.domain.movement.model.Movement;
import com.iobuilder.test.domain.movement.model.MovementEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MovementEntityMapper {

  public Movement toDomain(MovementEntity movementEntity){
    Movement movement = new Movement();
    BeanUtils.copyProperties(movementEntity,movement);
    return movement;
  }

  public MovementEntity toEntity(Movement movement){
    MovementEntity movementEntity = new MovementEntity();
    BeanUtils.copyProperties(movement,movementEntity);
    return movementEntity;
  }
}