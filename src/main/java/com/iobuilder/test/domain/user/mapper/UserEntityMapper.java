package com.iobuilder.test.domain.user.mapper;

import com.iobuilder.test.domain.user.model.User;
import com.iobuilder.test.domain.user.model.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

  public User toDomain(UserEntity userEntity){
    User user = new User();
    BeanUtils.copyProperties(userEntity,user);
    return user;
  }

  public UserEntity toEntity(User user){
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(user,userEntity);
    return userEntity;
  }
}