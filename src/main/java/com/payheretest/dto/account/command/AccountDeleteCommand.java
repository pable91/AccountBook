package com.payheretest.dto.account.command;

import lombok.Getter;

@Getter
public class AccountDeleteCommand {
    private String userId;
    private Long accountId;

    public AccountDeleteCommand(String userId, Long accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }
}
