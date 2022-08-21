package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class NotLoginException extends CustomException {

    public NotLoginException(ErrorCode code) {
        super(code);
    }
}
