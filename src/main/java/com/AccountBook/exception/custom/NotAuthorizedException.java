package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class NotAuthorizedException extends CustomException {

    public NotAuthorizedException(ErrorCode code) {
        super(code);
    }
}
