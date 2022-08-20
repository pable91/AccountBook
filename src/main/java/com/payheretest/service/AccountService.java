package com.payheretest.service;

import com.payheretest.dto.account.command.AccountAddCommand;
import com.payheretest.dto.account.command.AccountDeleteCommand;
import com.payheretest.dto.account.command.AccountModifyCommand;
import com.payheretest.dto.account.command.AccountRestoreCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class AccountService {

    public void add(AccountAddCommand command) {
        log.info("account add");
    }

    public void modify(AccountModifyCommand command) {
        log.info("account modify");
    }

    public void delete(AccountDeleteCommand command) {
        log.info("account delete");
    }

    public void restore(AccountRestoreCommand command) {
        log.info("account restore");
    }
}
