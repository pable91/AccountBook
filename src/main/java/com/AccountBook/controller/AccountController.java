package com.AccountBook.controller;

import com.AccountBook.dto.account.command.AccountBaseCommand;
import com.AccountBook.dto.account.AccountEventRequest;
import com.AccountBook.model.Account;
import com.AccountBook.model.response.SuccessResponse;
import com.AccountBook.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountEventHandler accountEventHandler;

    private final AccountService accountService;

    @PostMapping("/events")
    public ResponseEntity<SuccessResponse> accountEvent(@RequestBody @Valid AccountEventRequest request) {
        log.info("account event: {}", request);

        AccountBaseCommand accountBaseCommand = accountEventHandler.handle(request);

        return SuccessResponse.toResponseEntity(request.getAction(), accountBaseCommand);
    }

    @GetMapping("/find")
    public ResponseEntity findAllAccount() {
        log.info("account find all");

        List<Account> list = accountService.findAll();

        return SuccessResponse.toResponseEntity("find all account", list);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity findAccount(@PathVariable String email) {
        log.info("account find all");

        Account account = accountService.findByEmail(email);

        return SuccessResponse.toResponseEntity("find account", account);
    }
}
