package com.AccountBook.controller;

import com.AccountBook.dto.account.AccountEventRequest;
import com.AccountBook.dto.account.command.*;
import com.AccountBook.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountEventHandler {

    private final AccountService accountService;

    public AccountBaseCommand handle(AccountEventRequest request) {

        switch (request.getAction()) {
            case ADD:
                AccountAddCommand accountAddCommand = request.toAccountAddCommand();
                accountService.add(accountAddCommand);
                return accountAddCommand;
            case MODIFY:
                AccountModifyCommand accountModifyCommand = request.toAccountModCommand();
                accountService.modify(accountModifyCommand);
                return accountModifyCommand;
            case DELETE:
                AccountDeleteCommand accountDeleteCommand = request.toAccountDelCommand();
                accountService.delete(accountDeleteCommand);
                return accountDeleteCommand;
            case RESTORE:
                AccountRestoreCommand accountRestoreCommand = request.toAccountRestoreCommand();
                accountService.restore(accountRestoreCommand);
                return accountRestoreCommand;
            default:
                throw new IllegalArgumentException("지원하지 않는 ACTION 입니다. action: " + request.getAction());
        }
    }
}
