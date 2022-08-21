package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class NoMatchPasswordException extends CustomException {

    public NoMatchPasswordException(ErrorCode code) {
        super(code);
    }
}

