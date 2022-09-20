package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class NotLoginException extends CustomException {

    public NotLoginException(ErrorCode code) {
        super(code);
    }
}
