package com.iobuilder.bank.domain.user;

import com.iobuilder.bank.domain.user.mapper.UserMapper;
import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;
    private UserDto userDto;
    private User user;

    @BeforeEach
    public void init() {

        String STR = "STR";
        UUID ID = UUID.randomUUID();
        user = new User();
        user.setAge(1);
        user.setId(ID);
        user.setName(STR);
        user.setNif(STR);
        user.setSurname(STR);
        userDto = new UserDto();
        userDto.setAge(1);
        userDto.setId(ID);
        userDto.setName(STR);
        userDto.setNif(STR);
        userDto.setSurname(STR);
    }

    @Test
    public void toDomain() {
        User user = userMapper.toDomain(userDto);
        assertNotNull(user);
        assertEquals(user.getAge(), userDto.getAge());
        assertEquals(user.getName(), userDto.getName());
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getSurname(), userDto.getSurname());
        assertEquals(user.getNif(), userDto.getNif());
    }

    @Test
    public void toDto() {
        UserDto userDto = userMapper.toDto(user);
        assertNotNull(user);
        assertEquals(user.getAge(), userDto.getAge());
        assertEquals(user.getName(), userDto.getName());
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getSurname(), userDto.getSurname());
        assertEquals(user.getNif(), userDto.getNif());
    }
}
