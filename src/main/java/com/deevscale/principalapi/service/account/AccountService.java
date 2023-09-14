package com.deevscale.principalapi.service.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.models.request.AccountRequest;
import com.deevscale.principalapi.repository.account.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountSecurityService accountSecurityService;
    public AccountService(
            AccountRepository accountRepository,
            AccountSecurityService accountSecurityService
    ) {
        this.accountRepository = accountRepository;
        this.accountSecurityService = accountSecurityService;
    }

    public Account addNew(AccountRequest accountRequest) {

        String hashedPassword = accountRequest.password() != null ? accountSecurityService.hashPassword(accountRequest.password()) : null;

        Account account = Account.builder()
                .username(accountRequest.username())
                .password(hashedPassword)
                .build();

        return accountRepository.save(account);
    }

}
