package com.iobuilder.bank.domain.user.service.impl;

import com.iobuilder.bank.domain.user.mapper.UserEntityMapper;
import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserEntity;
import com.iobuilder.bank.domain.user.service.UserService;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;
import com.iobuilder.bank.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) throws ConflictException {
        Optional<UserEntity> userEntity = userRepository.findByNif(user.getNif());
        if(userEntity.isPresent()){
            throw new ConflictException("There is already an user created for this nif");
        }
        return userEntityMapper.toDomain(userRepository.save(userEntityMapper.toEntity(user)));
    }
}
