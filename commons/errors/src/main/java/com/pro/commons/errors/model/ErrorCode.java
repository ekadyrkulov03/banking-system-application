package com.pro.commons.errors.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // user-service
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "User already exists"),

    // commons
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "Validation failed"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

    // currency
    CURRENCY_NOT_FOUND(HttpStatus.NOT_FOUND, "Currency not found"),

    // country
    COUNTRY_NOT_FOUND(HttpStatus.NOT_FOUND, "Country not found");

    private final HttpStatus status;
    private final String defaultMessage;

}
