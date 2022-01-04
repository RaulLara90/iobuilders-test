package com.iobuilder.bank.domain.user.mapper;

import com.iobuilder.bank.domain.user.model.User;
import com.iobuilder.bank.domain.user.model.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

   public User toDomain(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
       return user;
    }
}