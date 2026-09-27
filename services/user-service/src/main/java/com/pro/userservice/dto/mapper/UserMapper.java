package com.pro.userservice.dto.mapper;

import com.pro.userservice.dto.request.UserCreateRequest;
import com.pro.userservice.dto.response.UserDto;
import com.pro.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public User toUser(UserCreateRequest request) {
        User user = new User();

        user.setUuid(UUID.randomUUID());
        user.setPhoneCountryCode(request.phoneCountryCode());
        user.setPhoneNumber(request.phoneNumber());
        user.setPasswordHash(request.password());

        return user;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setUuid(user.getUuid());
        userDto.setPhoneCountryCode(user.getPhoneCountryCode());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}
