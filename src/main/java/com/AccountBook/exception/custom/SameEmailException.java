package com.AccountBook.exception.custom;

import com.AccountBook.model.response.ErrorCode;

public class SameEmailException extends CustomException {

    public SameEmailException(ErrorCode errorCode) {
        super(errorCode);
    }
}
