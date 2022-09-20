package com.AccountBook.dto.account.command;

import lombok.Getter;

@Getter
public class AccountDeleteCommand extends AccountBaseCommand {
    private String email;
    private Long accountId;

    public AccountDeleteCommand(String email, Long accountId) {
        this.email = email;
        this.accountId = accountId;
    }
}
