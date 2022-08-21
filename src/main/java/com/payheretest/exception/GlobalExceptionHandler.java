package com.payheretest.exception;

import com.payheretest.exception.custom.CustomException;
import com.payheretest.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 사용자 정의 예외에 대한 Response 처리
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customException(CustomException e) {
        e.printStackTrace();
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
