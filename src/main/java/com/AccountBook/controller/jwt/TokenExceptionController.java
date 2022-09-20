package com.AccountBook.controller.jwt;

import com.AccountBook.model.response.ErrorCode;
import com.AccountBook.exception.custom.NotLoginException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenExceptionController {

    @GetMapping("/exception/entrypoint")
    public void entryPoint() {
        throw new NotLoginException(ErrorCode.NO_LOGIN);
    }

//    @GetMapping("/exception/access")
//    public void denied() {
//        throw new NotAuthorizedException(ErrorCode.NO_ADMIN);
//    }
}
