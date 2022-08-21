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
                .orElseThrow(() -> new NotFoundAccountException("가계부 정보를 찾을 수 없습니다"));

        findAccount.setActive(true);

        repository.save(findAccount);
    }

    public Account findActiveAccountByEmail(String email) {
        Optional<Account> account = repository.findActiveByEmail(email);
        return account
                .orElseThrow(() -> new NotFoundAccountException("가계부 정보를 찾을 수 없습니다"));
    }

    @Transactional(readOnly = true)
    public List<Account> findAll() {
        List<Account> accounts = repository.findActiveAll();

        if (accounts.isEmpty()) {
            throw new NotFoundAccountException("가계부 정보를 찾을 수 없습니다");
        }

        return accounts;
    }

    @Transactional(readOnly = true)
    public Account findByEmail(String email) {
        Optional<Account> account = repository.findByEmail(email);

        return account
                .orElseThrow(() -> new NotFoundAccountException("가계부 정보를 찾을 수 없습니다"));
    }

}
