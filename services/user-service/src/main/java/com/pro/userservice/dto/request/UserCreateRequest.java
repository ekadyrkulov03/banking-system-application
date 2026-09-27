package com.pro.userservice.dto.request;

public record UserCreateRequest(

        String phoneCountryCode,
        String phoneNumber,
        String password,
        String countryIsoCodeAlpha2

) {}
