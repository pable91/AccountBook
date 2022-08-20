package com.payheretest.service;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountDeleteCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
import com.payheretest.dto.account.command.AccountRestoreCommand;
import com.payheretest.exception.NotFoundAccountException;
import com.payheretest.model.Account;
import com.payheretest.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public void add(AccountAddCommand command) {
        log.info("account add");

        Account account = new Account(command);

        repository.save(account);
    }

    public void modify(AccountModifyCommand command) {
        log.info("account modify");

        Account account = findAccountById(command.getAccountId());
        account.modifyAccount(command);

        repository.save(account);
    }

    public void delete(AccountDeleteCommand command) {
        log.info("account delete");

        Account account = findAccountById(command.getAccountId());
        account.setActive(false);

        repository.save(account);
    }

    public void restore(AccountRestoreCommand command) {
        log.info("account restore");

        Account account = findAccountById(command.getAccountId());
        account.setActive(true);

        repository.save(account);
    }

    public Account findAccountById(Long accountId) {
        Optional<Account> account = repository.findById(accountId);
        return account.orElseThrow(NotFoundAccountException::new);
    }
}
