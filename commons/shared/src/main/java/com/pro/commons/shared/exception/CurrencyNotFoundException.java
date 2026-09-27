package com.pro.commons.shared.exception;

import com.pro.commons.errors.exceptions.ApplicationException;
import com.pro.commons.errors.model.ErrorCode;

public class CurrencyNotFoundException extends ApplicationException {

    public CurrencyNotFoundException(String message) {
        super(ErrorCode.CURRENCY_NOT_FOUND, message);
    }

}
