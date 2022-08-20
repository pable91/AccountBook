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

    @NotBlank(message = "email 값을 입력해주세요.")
    private String email;

    @NotNull
    private Action action;

    private Long accountId;

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
                email,
                money,
                content
        );
    }

    public AccountModifyCommand toAccountModCommand() {
        return new AccountModifyCommand(
                email,
                accountId,
                money,
                content
        );
    }

    public AccountDeleteCommand toAccountDelCommand() {
        return new AccountDeleteCommand(
                email,
                accountId
        );
    }

    public AccountRestoreCommand toAccountRestoreCommand() {
        return new AccountRestoreCommand(
                email,
                accountId
        );
    }
}
