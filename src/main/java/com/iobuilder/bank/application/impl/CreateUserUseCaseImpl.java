package com.iobuilder.bank.application.impl;

import com.iobuilder.bank.application.CreateUserUseCase;
import com.iobuilder.bank.domain.user.mapper.UserMapper;
import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.domain.user.service.UserService;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserService userService;
    private final UserMapper userMapper;

    public CreateUserUseCaseImpl(UserService userService,
                                 UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) throws ConflictException {
        return userMapper.toDto(userService.createUser(userMapper.toDomain(userDto)));
    }
}
