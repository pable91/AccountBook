package com.AccountBook.exception;

import com.AccountBook.exception.custom.CustomException;
import com.AccountBook.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
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
        log.error(e.getErrorCode().getDetail());
        e.printStackTrace();
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
