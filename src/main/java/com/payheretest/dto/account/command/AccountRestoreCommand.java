package com.payheretest.dto.account.command;

import lombok.Getter;

@Getter
public class AccountRestoreCommand {

    private String userId;
    private Long accountId;

    public AccountRestoreCommand(String userId, Long accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }
}
