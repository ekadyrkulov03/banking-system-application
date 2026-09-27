package com.pro.userservice.exception;

import com.pro.commons.errors.exceptions.ApplicationException;
import com.pro.commons.errors.model.ErrorCode;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException(String message) {
        super(ErrorCode.USER_NOT_FOUND, message);
    }

}
