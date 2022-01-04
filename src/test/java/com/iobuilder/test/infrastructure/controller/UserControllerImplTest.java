package com.iobuilder.test.infrastructure.controller;

import com.iobuilder.test.application.CreateUserUseCase;
import com.iobuilder.test.domain.user.model.UserDto;
import com.iobuilder.test.infrastructure.contoller.impl.UserControllerImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserControllerImplTest {

    @InjectMocks
    private UserControllerImpl userController;
    @Mock
    private CreateUserUseCase createUserUseCase;
    @Mock
    private UserDto userDto;

    @Test
    public void createUser() throws Exception {

        when(createUserUseCase.createUser(any())).thenReturn(userDto);
        ResponseEntity<UserDto> res = userController.createUser(userDto);
        assertNotNull(res);

    }
}
