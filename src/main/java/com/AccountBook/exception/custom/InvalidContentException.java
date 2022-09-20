package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class InvalidContentException extends CustomException {

    public InvalidContentException(ErrorCode code) {
        super(code);
    }
}

