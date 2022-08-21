package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class NotFoundUserException extends CustomException {

    public NotFoundUserException(ErrorCode code) {
        super(code);
    }
}
