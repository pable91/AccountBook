package com.payheretest.model.response;

import com.payheretest.dto.account.AccountEventRequest;
import com.payheretest.dto.account.command.AccountBaseCommand;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
public class SuccessResponse<T> {

    private String result;
    private String type;
    private T data;

    public SuccessResponse(String result, String type, T data) {
        this.result = result;
        this.type = type;
        this.data = data;
    }

    public static ResponseEntity<SuccessResponse> toResponseEntity(AccountEventRequest.Action action, AccountBaseCommand accountBaseCommand) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.builder()
                        .result("Success")
                        .type(SuccessCode.ADD.getDetailMessage(action.name()))
                        .data(accountBaseCommand)
                        .build()
                );
    }

    public static ResponseEntity<SuccessResponse> toResponseEntity(String type, Object obj) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.builder()
                        .result("Success")
                        .type(type)
                        .data(obj)
                        .build()
                );
    }

    public static ResponseEntity<SuccessResponse> toSignUpResponseEntity(Object data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(SuccessResponse.builder()
                        .result("Success")
                        .type("회원가입 완료")
                        .data(data)
                        .build()
                );
    }

    public static ResponseEntity<SuccessResponse> toLoginResponseEntity(String data) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("JWT", data)
                .body(SuccessResponse.builder()
                        .result("Success")
                        .type("로그인 완료")
                        .data(data)
                        .build()
                );
    }

    public static ResponseEntity<SuccessResponse> toLogoutResponseEntity(String tokenValue) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("JWT", tokenValue)
                .body(SuccessResponse.builder()
                        .result("Success")
                        .type("로그아웃 완료")
                        .data("")
                        .build()
                );
    }
}
