package com.AccountBook.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SuccessCode {

    ADD("요청한 가계부 등록이 성공하였습니다"),
    MODIFY("요청한 가계부 수정을 성공하였습니다"),
    DELETE("요청한 가계부 삭제가 성공하였습니다"),
    RESTORE("요청한 가계부를 복구 성공하였습니다");

    private String detail;

    public String getDetailMessage(String actionName) {
        SuccessCode[] values = values();

        return Arrays.stream(values)
                .filter(code -> code.name().equals(actionName))
                .findFirst()
                .map(SuccessCode::getDetail)
                .orElse("알 수 없는 Action 타입입니다.");
    }
}
