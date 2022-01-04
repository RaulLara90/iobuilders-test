package com.iobuilder.bank.domain.user;

import com.iobuilder.bank.domain.user.mapper.UserEntityMapper;
import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class UserEntityMapperTest {

    @InjectMocks
    private UserEntityMapper userEntityMapper;
    private UserEntity userEntity;
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
        userEntity = new UserEntity();
        userEntity.setAge(1);
        userEntity.setId(ID);
        userEntity.setName(STR);
        userEntity.setNif(STR);
        userEntity.setSurname(STR);
    }

    @Test
    public void toDomain() {
        User user = userEntityMapper.toDomain(userEntity);
        assertNotNull(user);
        assertEquals(user.getAge(), userEntity.getAge());
        assertEquals(user.getName(), userEntity.getName());
        assertEquals(user.getId(), userEntity.getId());
        assertEquals(user.getSurname(), userEntity.getSurname());
        assertEquals(user.getNif(), userEntity.getNif());
    }

    @Test
    public void toEntity() {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        assertNotNull(user);
        assertEquals(user.getAge(), userEntity.getAge());
        assertEquals(user.getName(), userEntity.getName());
        assertEquals(user.getId(), userEntity.getId());
        assertEquals(user.getSurname(), userEntity.getSurname());
        assertEquals(user.getNif(), userEntity.getNif());
    }
}
