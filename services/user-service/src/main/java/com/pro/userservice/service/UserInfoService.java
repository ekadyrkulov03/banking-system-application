package com.pro.userservice.service;

import com.pro.userservice.dto.request.UserCreateRequest;
import com.pro.userservice.dto.response.UserDto;
import com.pro.userservice.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserService userService;

    public UUID createUser(UserCreateRequest request) {
        return userService.createUser(request);
    }

    public UserDto findUserByUuid(UUID uuid) {
        return userService.findUserByUuid(uuid);
    }
}
