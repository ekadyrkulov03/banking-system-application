package com.pro.userservice.controller;

import com.pro.userservice.dto.request.UserCreateRequest;
import com.pro.userservice.dto.response.UserDto;
import com.pro.userservice.model.User;
import com.pro.userservice.service.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService userInfoService;

    @PostMapping
    public ResponseEntity<UUID> createUser(@RequestBody @Valid UserCreateRequest request) {
        UUID uuid = userInfoService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(uuid);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID uuid) {
        return ResponseEntity.ok(userInfoService.findUserByUuid(uuid));
    }

}
