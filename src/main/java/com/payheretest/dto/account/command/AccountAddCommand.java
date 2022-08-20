package com.payheretest.dto.account.command;

public class AccountAddCommand {

    private static final int ZERO = 0;

    private String userId;
    private int money;
    private String content;

    public AccountAddCommand(String userId, int money, String content) {
        validate(money, content);

        this.userId = userId;
        this.money = money;
        this.content = content;
    }

    private void validate(int money, String content) {
        if (money <= ZERO)
            throw new IllegalArgumentException("money 는 0을 넘어야 합니다.");

        if (content == null)
            throw new IllegalArgumentException("content 가 null 입니다");
    }
}
