package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class NotAuthorizedException extends CustomException {

    public NotAuthorizedException(ErrorCode code) {
        super(code);
    }
}
