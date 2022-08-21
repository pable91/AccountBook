package com.payheretest.exception.custom;

import com.payheretest.exception.custom.CustomException;
import com.payheretest.model.response.ErrorCode;

public class InvalidContentException extends CustomException {

    public InvalidContentException(ErrorCode code) {
        super(code);
    }
}

