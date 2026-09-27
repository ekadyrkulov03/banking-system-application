package com.pro.userservice.exception;

import com.pro.commons.errors.exceptions.ApplicationException;
import com.pro.commons.errors.model.ErrorCode;

public class UserAlreadyExistsException extends ApplicationException {

    public UserAlreadyExistsException(String message) {
        super(ErrorCode.USER_ALREADY_EXISTS, message);
    }

}
