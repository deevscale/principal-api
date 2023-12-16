package com.deevscale.principalapi.service.account;

import com.deevscale.principalapi.entity.account.Account;
import com.deevscale.principalapi.entity.login.AccountApplicationLogin;
import com.deevscale.principalapi.repository.account.AccountRepository;
import com.deevscale.principalapi.repository.auth.AuthPasswordRepository;
import com.deevscale.principalmodel.api.request.AccountRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

class AccountServiceTest {

    private AccountService principal;

    private AccountSecurityService accountSecurityService;
    private AccountRepository accountRepository;
    private AuthPasswordRepository authPasswordRepository;
    private KafkaTemplate<String, String> kafkaTemplate;

    @BeforeEach
    void prepare() {
        accountSecurityService = Mockito.mock();
        accountRepository = Mockito.mock();
        authPasswordRepository = Mockito.mock();
        kafkaTemplate = Mockito.mock();
        principal = new AccountService(accountRepository, accountSecurityService, authPasswordRepository, kafkaTemplate, "");

    }

    @Test
    void addNew_whenRequestIsSent_thenReturnCreatedAccountEntity() {
        AccountRequest mockRequest = new AccountRequest("username", "password");
        Mockito.when( accountRepository.save(Mockito.any())).thenReturn(Account.builder().username("saved username").id(UUID.randomUUID()).build());
        Mockito.when(accountSecurityService.hashPassword(Mockito.any())).thenReturn("hashed password");
        Mockito.when(authPasswordRepository.save(Mockito.any())).thenReturn(AccountApplicationLogin.AccountLoginAuthPassword.builder().password("saved password").build());
        Account actualAccount = principal.addNew(mockRequest);
        Assertions.assertNotNull(actualAccount.getId());
        Assertions.assertEquals("saved username", actualAccount.getUsername());
    }
}