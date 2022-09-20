package com.AccountBookTest.dto.account;

import com.AccountBook.dto.account.command.AccountModifyCommand;
import com.AccountBook.exception.custom.InvalidContentException;
import com.AccountBook.exception.custom.InvalidMoneyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AccountModCommandTest {

    @ParameterizedTest
    @ValueSource(ints= {-100, -1})
    @DisplayName("money 가 음수값이면 예외를 던진다.")
    public void moneyExceptionTest(int money) {
        Assertions.assertThrows(InvalidMoneyException.class, () -> {
            new AccountModifyCommand("userid", 1L, money, "test");
        });
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("content 가 null 이면 예외를 던진다.")
    public void contentExceptionTest(String content) {
        Assertions.assertThrows(InvalidContentException.class, () -> {
            new AccountModifyCommand("userid", 1L, 1000, content);
        });
    }
}
