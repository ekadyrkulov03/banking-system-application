package com.pro.userservice.exception;

import com.pro.commons.errors.exceptions.ApplicationException;
import com.pro.commons.errors.model.ErrorCode;

public class CountryNotFoundException extends ApplicationException {

    public CountryNotFoundException(String message) {
        super(ErrorCode.COUNTRY_NOT_FOUND, message);
    }

}
