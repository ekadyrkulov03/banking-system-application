package com.pro.userservice.service;

import com.pro.commons.errors.model.ErrorCode;
import com.pro.userservice.dto.mapper.UserMapper;
import com.pro.userservice.dto.request.UserCreateRequest;
import com.pro.userservice.dto.response.UserDto;
import com.pro.userservice.exception.CountryNotFoundException;
import com.pro.userservice.exception.UserAlreadyExistsException;
import com.pro.userservice.exception.UserNotFoundException;
import com.pro.userservice.model.Country;
import com.pro.userservice.model.User;
import com.pro.userservice.repository.CountryRepository;
import com.pro.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    private final UserMapper userMapper;

    @Transactional
    public UUID createUser(UserCreateRequest request) {
        if (userRepository.existsByPhoneCountryCodeAndPhoneNumber(
                request.phoneCountryCode(),
                request.phoneNumber())
        ) {
            throw new UserAlreadyExistsException(
                    "User with phone number: %s already exists".formatted(
                            request.phoneCountryCode() + request.phoneNumber()
                    ));
        }

        Country country = countryRepository.findByIsoCodeAlpha2(request.countryIsoCodeAlpha2())
                .orElseThrow(() -> new CountryNotFoundException(
                        "Country with iso code (alpha-2): %s not found"
                                .formatted(request.countryIsoCodeAlpha2())
                ));

        User user = userMapper.toUser(request);

        user.setCountry(country);

        userRepository.save(user);

        return user.getUuid();
    }

    public UserDto findUserByUuid(UUID uuid) {
        return userMapper.toUserDto(findUserByUuidOrThrow(uuid));
    }

    @Transactional
    public void verifyUser(UUID uuid) {
        User user = findUserByUuidOrThrow(uuid);

        user.setIsVerified(true);
    }

    private User findUserByUuidOrThrow(UUID uuid) {
        return userRepository.findByUuid(uuid)
                .orElseThrow(() -> new UserNotFoundException(
                        "User with id: %s not found".formatted(uuid.toString())
                ));
    }

}
