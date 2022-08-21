package com.payheretest.exception.custom;

import com.payheretest.exception.custom.CustomException;
import com.payheretest.model.response.ErrorCode;

public class InvalidMoneyException extends CustomException {

    public InvalidMoneyException(ErrorCode code) {
        super(code);
    }
}

