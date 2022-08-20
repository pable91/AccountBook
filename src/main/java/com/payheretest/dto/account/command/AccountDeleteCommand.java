package com.payheretest.dto.account.command;

import lombok.Getter;

@Getter
public class AccountDeleteCommand {
    private String userId;
    private String accountId;

    public AccountDeleteCommand(String userId, String accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }
}
