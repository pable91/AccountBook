package com.payheretest.dto.account;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new AccountModifyCommand("userid", "accountid", money, "test");
        });
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("content 가 null 이면 예외를 던진다.")
    public void contentExceptionTest(String content) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new AccountModifyCommand("userid", "accountid", 1000, content);
        });
    }
}
