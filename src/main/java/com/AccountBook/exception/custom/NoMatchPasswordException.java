package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class NoMatchPasswordException extends CustomException {

    public NoMatchPasswordException(ErrorCode code) {
        super(code);
    }
}

