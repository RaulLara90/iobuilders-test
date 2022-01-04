package com.iobuilder.bank.infrastructure.controller;

import com.iobuilder.bank.application.CreateUserUseCase;
import com.iobuilder.bank.domain.user.model.UserDto;
import com.iobuilder.bank.infrastructure.contoller.impl.UserControllerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
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
