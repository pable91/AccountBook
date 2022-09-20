package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class NotFoundUserException extends CustomException {

    public NotFoundUserException(ErrorCode code) {
        super(code);
    }
}
