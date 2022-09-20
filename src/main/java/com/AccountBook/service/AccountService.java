package com.AccountBook.service;

import com.AccountBook.dto.account.command.AccountRestoreCommand;
import com.AccountBook.exception.custom.NotFoundAccountException;
import com.AccountBook.model.response.ErrorCode;
import com.AccountBook.dto.account.command.AccountAddCommand;
import com.AccountBook.dto.account.command.AccountDeleteCommand;
import com.AccountBook.dto.account.command.AccountModifyCommand;
import com.AccountBook.model.Account;
import com.AccountBook.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

        Account account = findActiveAccountByEmail(command.getEmail());
        account.modifyAccount(command);

        repository.save(account);
    }

    public void delete(AccountDeleteCommand command) {
        log.info("account delete");

        Account account = findActiveAccountByEmail(command.getEmail());
        account.setActive(false);

        repository.save(account);
    }

    public void restore(AccountRestoreCommand command) {
        log.info("account restore");

        Optional<Account> account = repository.findByEmail(command.getEmail());

        Account findAccount = account
                .orElseThrow(() -> new NotFoundAccountException(ErrorCode.NOT_FOUND_ACCOUNT));

        findAccount.setActive(true);

        repository.save(findAccount);
    }

    public Account findActiveAccountByEmail(String email) {
        Optional<Account> account = repository.findActiveByEmail(email);
        return account
                .orElseThrow(() -> new NotFoundAccountException(ErrorCode.NOT_FOUND_ACCOUNT));
    }

    @Transactional(readOnly = true)
    public List<Account> findAll() {
        List<Account> accounts = repository.findActiveAll();

        if (accounts.isEmpty()) {
            throw new NotFoundAccountException(ErrorCode.NOT_FOUND_ACCOUNT);
        }

        return accounts;
    }

    @Transactional(readOnly = true)
    public Account findByEmail(String email) {
        Optional<Account> account = repository.findByEmail(email);

        return account
                .orElseThrow(() -> new NotFoundAccountException(ErrorCode.NOT_FOUND_ACCOUNT));
    }

}
