package com.payheretest.service;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountDeleteCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
import com.payheretest.dto.account.command.AccountRestoreCommand;
import com.payheretest.exception.custom.NotFoundAccountException;
import com.payheretest.model.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("가계부 내역 등록 테스트")
    void addAccountTest() {
        AccountAddCommand command = new AccountAddCommand("a", 100, "test content1");

        accountService.add(command);

        Account account = accountService.findByEmail("a");
        Assertions.assertThat(account.getEmail()).isEqualTo("a");
        Assertions.assertThat(account.getMoney()).isEqualTo(100);
        Assertions.assertThat(account.getContent()).isEqualTo("test content1");
    }

    @Test
    @DisplayName("가계부 내역 수정 테스트")
    void modifyAccountTest() {
        AccountAddCommand addCommand = new AccountAddCommand("a", 100, "abc");
        accountService.add(addCommand);
        AccountModifyCommand modCommand = new AccountModifyCommand("a", 1L, 500, "test");

        accountService.modify(modCommand);

        Account account = accountService.findByEmail("a");
        Assertions.assertThat(account.getMoney()).isEqualTo(500);
        Assertions.assertThat(account.getContent()).isEqualTo("test");
    }

    @Test
    @DisplayName("가계부 내역 삭제 테스트")
    void deleteAccountTest() {
        AccountAddCommand command = new AccountAddCommand("a", 100, "test content1");
        accountService.add(command);
        AccountDeleteCommand deleteCommand = new AccountDeleteCommand("a", 1L);
        Account account = accountService.findByEmail("a");

        Assertions.assertThat(account.isActive()).isTrue();
        accountService.delete(deleteCommand);

        Assertions.assertThat(account.isActive()).isFalse();
    }

    @Test
    @DisplayName("삭제한 가계부 내역 원상복귀 테스트")
    void restoreAccountTest() {
        AccountAddCommand command = new AccountAddCommand("a", 100, "test content1");
        accountService.add(command);
        AccountDeleteCommand deleteCommand = new AccountDeleteCommand("a", 1L);
        accountService.delete(deleteCommand);
        Account account = accountService.findByEmail("a");

        Assertions.assertThat(account.isActive()).isFalse();
        AccountRestoreCommand restoreCommand = new AccountRestoreCommand("a", 5L);
        accountService.restore(restoreCommand);

        Assertions.assertThat(account.isActive()).isTrue();
    }

    @Test
    @DisplayName("대상 account 가 없으면 예외를 던진다")
    void notFoundAccountExceptionTest() {
        AccountAddCommand command = new AccountAddCommand("a", 100, "test content1");

        accountService.add(command);
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundAccountException.class,
                () -> accountService.findByEmail("b"));

        AccountDeleteCommand deleteCommand = new AccountDeleteCommand("b", 1L);
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundAccountException.class,
                () -> accountService.delete(deleteCommand));

        AccountModifyCommand modCommand = new AccountModifyCommand("b", 1L, 500, "test");
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundAccountException.class,
                () -> accountService.modify(modCommand));

        AccountRestoreCommand restoreCommand = new AccountRestoreCommand("b", 5L);
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundAccountException.class,
                () ->  accountService.restore(restoreCommand));
    }

    @Test
    @DisplayName("모든 가계부 내역을 가져오는 테스트")
    void findAllTest() {
        AccountAddCommand command1 = new AccountAddCommand("a", 100, "test content1");
        accountService.add(command1);

        AccountAddCommand command2 = new AccountAddCommand("b", 200, "abc");
        accountService.add(command2);

        AccountAddCommand command3 = new AccountAddCommand("c", 300, "abc");
        accountService.add(command3);

        Account account1 = accountService.findByEmail("a");
        Account account2 = accountService.findByEmail("b");
        Account account3 = accountService.findByEmail("c");

        List<Account> accountList = accountService.findAll();
        Assertions.assertThat(accountList.get(0)).isEqualTo(account1);
        Assertions.assertThat(accountList.get(1)).isEqualTo(account2);
        Assertions.assertThat(accountList.get(2)).isEqualTo(account3);
    }

    @Test
    @DisplayName("email 로 해당 가계부 내역을 찾는 테스트")
    void findByEmailTest() {
        AccountAddCommand command1 = new AccountAddCommand("a", 100, "test content1");
        accountService.add(command1);

        AccountAddCommand command2 = new AccountAddCommand("b", 200, "test content2");
        accountService.add(command2);

        AccountAddCommand command3 = new AccountAddCommand("c", 300, "test content3");
        accountService.add(command3);

        Account account = accountService.findByEmail("c");

        Assertions.assertThat(account.getEmail()).isEqualTo("c");
        Assertions.assertThat(account.getMoney()).isEqualTo(300);
        Assertions.assertThat(account.getContent()).isEqualTo("test content3");
    }
}