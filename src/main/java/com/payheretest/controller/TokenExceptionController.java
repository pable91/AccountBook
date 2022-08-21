package com.payheretest.controller;

import com.payheretest.model.response.ErrorCode;
import com.payheretest.exception.custom.NotAuthorizedException;
import com.payheretest.exception.custom.NotLoginException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenExceptionController {

    @GetMapping("/exception/entrypoint")
    public void entryPoint() {
        throw new NotLoginException(ErrorCode.NO_LOGIN);
    }

    @GetMapping("/exception/access")
    public void denied() {
        throw new NotAuthorizedException(ErrorCode.NO_ADMIN);
    }
}
