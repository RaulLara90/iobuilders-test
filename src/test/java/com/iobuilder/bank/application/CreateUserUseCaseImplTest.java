package com.iobuilder.bank.application;

import com.iobuilder.bank.application.impl.CreateUserUseCaseImpl;
import com.iobuilder.bank.domain.user.mapper.UserMapper;
import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.domain.user.service.UserService;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CreateUserUseCaseImplTest {

    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;
    @Mock
    private UserService userService;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserDto userDto;
    @Mock
    private User user;

    @Test
    public void createUser() throws ConflictException {
        when(userMapper.toDomain(any())).thenReturn(user);
        when(userMapper.toDto(any())).thenReturn(userDto);
        when(userService.createUser(any())).thenReturn(user);
        UserDto res = createUserUseCase.createUser(userDto);
        assertNotNull(res);
    }

}