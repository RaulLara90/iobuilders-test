package com.iobuilder.bank.application;

import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;

public interface CreateUserUseCase {
    UserDto createUser(UserDto userDto) throws ConflictException;
}
