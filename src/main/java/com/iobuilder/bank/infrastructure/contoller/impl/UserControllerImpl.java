package com.iobuilder.bank.infrastructure.contoller.impl;

import com.iobuilder.bank.application.CreateUserUseCase;
import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import com.iobuilder.bank.infrastructure.contoller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserControllerImpl(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) throws ConflictException {
        return new ResponseEntity<>(createUserUseCase.createUser(userDto), HttpStatus.OK);
    }
}
