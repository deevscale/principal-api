package com.deevscale.principalapi.service.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.entity.auth.AuthPassword;
import com.deevscale.principalapi.repository.account.AccountRepository;
import com.deevscale.principalapi.repository.auth.AuthPasswordRepository;
import com.deevscale.principalmodel.api.request.AccountRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountSecurityService accountSecurityService;
    private final AccountRepository accountRepository;
    private final AuthPasswordRepository authPasswordRepository;

    public AccountService(
            AccountRepository accountRepository,
            AccountSecurityService accountSecurityService,
            AuthPasswordRepository authPasswordRepository
    ) {
        this.accountRepository = accountRepository;
        this.accountSecurityService = accountSecurityService;
        this.authPasswordRepository = authPasswordRepository;
    }

    public Account addNew(AccountRequest accountRequest) {

        String hashedPassword = accountRequest.password() != null ? accountSecurityService.hashPassword(accountRequest.password()) : null;

        Account account = accountRepository.save(Account.builder()
                .username(accountRequest.username())
                .build());

        authPasswordRepository.save(AuthPassword.builder()
                .accountId(account.getId())
                .password(hashedPassword)
                .build());

        return account;
    }

}
