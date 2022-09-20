package com.AccountBook.dto.account.command;

import com.AccountBook.model.response.ErrorCode;
import com.AccountBook.exception.custom.InvalidContentException;
import com.AccountBook.exception.custom.InvalidMoneyException;
import lombok.Getter;

@Getter
public class AccountModifyCommand extends AccountBaseCommand {

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
            throw new InvalidMoneyException(ErrorCode.INVALID_MONEY);

        if (content == null)
            throw new InvalidContentException(ErrorCode.CONTENT_NULL);
    }
}
