package com.iobuilder.test.application;

import com.iobuilder.test.domain.user.model.UserDto;
import com.iobuilder.test.infrastructure.config.exceptions.ConflictException;

public interface CreateUserUseCase {
    UserDto createUser(UserDto userDto) throws ConflictException;
}
