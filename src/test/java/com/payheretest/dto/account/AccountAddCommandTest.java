package com.payheretest.dto.account;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.InvalidContentException;
import com.payheretest.dto.account.command.InvalidMoneyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class AccountAddCommandTest {

    @ParameterizedTest
    @ValueSource(ints= {-100, -1, 0})
    @DisplayName("money 가 0이나 음수값이면 예외를 던진다.")
    public void moneyExceptionTest(int money) {
        Assertions.assertThrows(InvalidMoneyException.class, () -> {
           new AccountAddCommand("userid", money, "test");
        });
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("content 가 null 이면 예외를 던진다.")
    public void contentExceptionTest(String content) {
        Assertions.assertThrows(InvalidContentException.class, () -> {
            new AccountAddCommand("userid", 1000, content);
        });
    }
}