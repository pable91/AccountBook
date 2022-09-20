package com.AccountBook.dto.account.command;

import com.AccountBook.exception.custom.InvalidContentException;
import com.AccountBook.model.response.ErrorCode;
import com.AccountBook.exception.custom.InvalidMoneyException;
import lombok.Getter;

@Getter
public class AccountAddCommand extends AccountBaseCommand {

    private static final int ZERO = 0;

    private String email;
    private int money;
    private String content;

    public AccountAddCommand(String email, int money, String content) {
        validate(money, content);

        this.email = email;
        this.money = money;
        this.content = content;
    }

    private void validate(int money, String content) {
        if (money <= ZERO)
            throw new InvalidMoneyException(ErrorCode.INVALID_MONEY);

        if (content == null)
            throw new InvalidContentException(ErrorCode.CONTENT_NULL);
    }
}
