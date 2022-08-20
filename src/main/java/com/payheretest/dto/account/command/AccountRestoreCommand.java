package com.payheretest.dto.account.command;

public class AccountRestoreCommand {

    private String userId;
    private String accountId;

    public AccountRestoreCommand(String userId, String accountId) {
        // valid?

        this.userId = userId;
        this.accountId = accountId;
    }

}
