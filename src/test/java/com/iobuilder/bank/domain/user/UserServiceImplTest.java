package com.iobuilder.bank.domain.user;

import com.iobuilder.bank.domain.user.mapper.UserEntityMapper;
import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserEntity;
import com.iobuilder.bank.domain.user.service.impl.UserServiceImpl;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import com.iobuilder.bank.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserEntityMapper userEntityMapper;
    @Mock
    private UserEntity userEntity;
    @Mock
    private User user;

    @Test
    public void createUser() throws ConflictException {
        when(userRepository.findByNif(anyString())).thenReturn(Optional.empty());
        when(userEntityMapper.toEntity(any())).thenReturn(userEntity);
        when(userEntityMapper.toDomain(any())).thenReturn(user);
        User res = userService.createUser(user);
        assertNotNull(res);
    }

    @Test
    public void createUserException() {
        when(user.getNif()).thenReturn("STR");
        when(userRepository.findByNif(anyString())).thenReturn(Optional.of(userEntity));
        assertThrows(ConflictException.class, () -> userService.createUser(user));
    }


}