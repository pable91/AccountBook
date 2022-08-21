package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class SameEmailException extends CustomException {

    public SameEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
