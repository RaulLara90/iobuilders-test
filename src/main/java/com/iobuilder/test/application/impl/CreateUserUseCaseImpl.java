package com.iobuilder.test.application.impl;

import com.iobuilder.test.application.CreateUserUseCase;
import com.iobuilder.test.domain.user.mapper.UserMapper;
import com.iobuilder.test.domain.user.model.UserDto;
import com.iobuilder.test.domain.user.service.UserService;
import com.iobuilder.test.infrastructure.config.exceptions.ConflictException;
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
