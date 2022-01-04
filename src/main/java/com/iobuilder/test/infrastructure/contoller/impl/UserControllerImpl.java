package com.iobuilder.test.infrastructure.contoller.impl;

import com.iobuilder.test.application.CreateUserUseCase;
import com.iobuilder.test.domain.user.model.UserDto;
import com.iobuilder.test.infrastructure.config.exceptions.ConflictException;
import com.iobuilder.test.infrastructure.contoller.UserController;
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
