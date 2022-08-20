package com.payheretest.dto.account.command;

public class AccountModifyCommand {

    private static final int ZERO = 0;

    private String userId;
    private String accountId;
    private int money;
    private String content;

    public AccountModifyCommand(String userId, String accountId, int money, String content) {
        validate(money, content);

        this.userId = userId;
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
