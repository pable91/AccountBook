package com.payheretest.exception.custom;

import com.payheretest.model.response.ErrorCode;

public class NotFoundAccountException extends CustomException{

    public NotFoundAccountException(ErrorCode code) {
        super(code);
    }
}
