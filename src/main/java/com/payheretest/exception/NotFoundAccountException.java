package com.payheretest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundAccountException extends RuntimeException{

    public NotFoundAccountException(String msg) {
        super(msg);
    }
}
