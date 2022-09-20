package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class NotFoundAccountException extends CustomException {

    public NotFoundAccountException(ErrorCode code) {
        super(code);
    }
}
