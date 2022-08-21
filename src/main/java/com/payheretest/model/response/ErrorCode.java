package com.payheretest.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NO_MATCH_PASSWORD(HttpStatus.BAD_REQUEST, "암호가 일치하지않습니다"),
    SAME_EMAIL(HttpStatus.BAD_REQUEST, "동일한 이메일이 존재합니다."),
    NO_USER(HttpStatus.BAD_REQUEST, "없는 사용자입니다."),
    NO_LOGIN(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다"),
    NO_ADMIN(HttpStatus.FORBIDDEN, "권한이 없는 사용자입니다"),

    NOT_FOUND_ACCOUNT(HttpStatus.BAD_REQUEST, "가계부 정보를 찾을 수 없습니다");

    private HttpStatus httpStatus;
    private String detail;
}