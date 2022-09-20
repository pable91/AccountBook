package com.AccountBook.dto.account.command;

import lombok.Getter;

@Getter
public class AccountRestoreCommand extends AccountBaseCommand {

    private String email;
    private Long accountId;

    public AccountRestoreCommand(String email, Long accountId) {
        this.email = email;
        this.accountId = accountId;
    }
}
