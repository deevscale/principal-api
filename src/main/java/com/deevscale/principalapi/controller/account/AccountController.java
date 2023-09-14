package com.deevscale.principalapi.controller.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.mapper.account.AccountMapper;
import com.deevscale.principalapi.models.request.AccountRequest;
import com.deevscale.principalapi.models.response.AccountResponse;
import com.deevscale.principalapi.service.account.AccountService;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AccountController{

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
    public ResponseEntity<AccountResponse> addNew(@RequestBody AccountRequest accountRequest) {
        Account account = accountService.addNew(accountRequest);
        return ResponseEntity.ok(accountMapper.mapToResponse(account));
    }


}
