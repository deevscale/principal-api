package com.deevscale.principalapi.controller.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.mapper.account.AccountMapper;
import com.deevscale.principalapi.service.account.AccountService;
import com.deevscale.principalmodel.api.request.account.NewAccountRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Validated
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountController(
            AccountService accountService,
            AccountMapper accountMapper
    ) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }


    @PostMapping
    public ResponseEntity<UUID> addNew(@RequestBody NewAccountRequest newAccountRequest) {
        Account account = accountService.addNew(newAccountRequest);
        return ResponseEntity.ok(accountMapper.mapToId(account));
    }


}
