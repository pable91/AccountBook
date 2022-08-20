package com.payheretest.controller;

import com.payheretest.dto.account.AccountEventRequest;
import com.payheretest.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountEventHandler {

    private final AccountService accountService;

    public void handle(AccountEventRequest request) {

        switch (request.getAction()) {
            case ADD:
                accountService.add(request.toAccountAddCommand());
                break;
            case MODIFY:
                accountService.modify(request.toAccountModCommand());
                break;
            case DELETE:
                accountService.delete(request.toAccountDelCommand());
                break;
            case RESTORE:
                accountService.restore(request.toAccountRestoreCommand());
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 ACTION 입니다. action: " + request.getAction());
        }
    }
}
