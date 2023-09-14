package com.deevscale.principalapi.service.account;

import org.springframework.stereotype.Service;

@Service
public class AccountSecurityService {

    public String hashPassword(String plainText) {
        return plainText;
    }

}
