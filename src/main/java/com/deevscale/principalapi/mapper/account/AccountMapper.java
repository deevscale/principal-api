package com.deevscale.principalapi.mapper.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.mapper.ResponseMapper;
import com.deevscale.principalmodel.api.response.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements ResponseMapper<AccountResponse, Account> {

    @Override
    public AccountResponse mapToResponse(Account account) {
        return AccountResponse.builder()
                .id(account.id())
                .username(account.username())
                .build();
    }
}
