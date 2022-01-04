package com.iobuilder.bank.domain.user.service;

import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.infrastructure.config.exceptions.ConflictException;

public interface UserService {

    User createUser(User user) throws ConflictException;
}
