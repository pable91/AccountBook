package com.payheretest.dto.account.command;

import lombok.Getter;

@Getter
public class AccountModifyCommand {

    private static final int ZERO = 0;

    private String email;
    private Long accountId;
    private int money;
    private String content;

    public AccountModifyCommand(String email, Long accountId, int money, String content) {
        validate(money, content);

        this.email = email;
        this.accountId = accountId;
        this.money = money;
        this.content = content;
    }

    private void validate(int money, String content) {
        if (money < ZERO)
            throw new IllegalArgumentException("money 는 양수여야 합니다.");

        if (content == null)
            throw new IllegalArgumentException("content 가 null 입니다");
    }
}
