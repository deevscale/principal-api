package com.deevscale.principalapi.service.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountSecurityServiceTest {

    private AccountSecurityService principal;

    @BeforeEach
    void prepare() {
        this.principal = new AccountSecurityService();
    }

    @Test
    void hashPassword_wnePlainTextIsSent_thenReturnPlaintext() {
        String plainTextPassword = "Some password";
        String hashedPassword = principal.hashPassword(plainTextPassword);
        Assertions.assertEquals("Some password", hashedPassword);
    }
}