package com.payheretest.controller;

import com.payheretest.dto.account.AccountEventRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountEventHandler accountEventHandler;

    @PostMapping("/events")
    public void accountEvent(@RequestBody @Valid AccountEventRequest request) {
        log.info("consume review event: {}", request);

        accountEventHandler.handle(request);
    }
}
