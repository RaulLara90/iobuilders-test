package com.iobuilder.test.domain.user.service;

import com.iobuilder.test.domain.user.model.User;
import com.iobuilder.test.infrastructure.config.exceptions.ConflictException;

public interface UserService {

    User createUser(User user) throws ConflictException;
}
