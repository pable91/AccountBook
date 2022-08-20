package com.payheretest.dto.account;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountDeleteCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
import com.payheretest.dto.account.command.AccountRestoreCommand;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AccountEventRequest {

    @NotBlank
    private String userId;

    @NotNull
    private Action action;

    private String accountId;

    private String content;

    private int money;

    public enum Action {
        ADD,
        MODIFY,
        DELETE,
        RESTORE
    }

    public AccountAddCommand toAccountAddCommand() {
        return new AccountAddCommand(
                userId,
                money,
                content
        );
    }

    public AccountModifyCommand toAccountModCommand() {
        return new AccountModifyCommand(
                userId,
                accountId,
                money,
                content
        );
    }

    public AccountDeleteCommand toAccountDelCommand() {
        return new AccountDeleteCommand(
                userId,
                accountId
        );
    }

    public AccountRestoreCommand toAccountRestoreCommand() {
        return new AccountRestoreCommand(
                userId,
                accountId
        );
    }
}
