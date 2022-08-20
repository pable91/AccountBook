package com.payheretest.controller;

import com.payheretest.dto.account.AccountEventRequest;
import com.payheretest.dto.account.command.AccountBaseCommand;
import com.payheretest.model.Account;
import com.payheretest.model.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SuccessResponse> accountEvent(@RequestBody @Valid AccountEventRequest request) {
        log.info("consume review event: {}", request);

        AccountBaseCommand accountBaseCommand = accountEventHandler.handle(request);

        return SuccessResponse.toResponseEntity(request.getAction(), accountBaseCommand);
    }
}
