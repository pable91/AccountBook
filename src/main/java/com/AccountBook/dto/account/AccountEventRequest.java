package com.AccountBook.dto.account;

import com.AccountBook.dto.account.command.AccountRestoreCommand;
import com.AccountBook.dto.account.command.AccountAddCommand;
import com.AccountBook.dto.account.command.AccountDeleteCommand;
import com.AccountBook.dto.account.command.AccountModifyCommand;
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
