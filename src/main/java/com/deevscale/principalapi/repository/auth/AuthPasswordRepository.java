package com.deevscale.principalapi.repository.auth;

import com.deevscale.principalapi.entity.login.AccountApplicationLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthPasswordRepository extends JpaRepository<AccountApplicationLogin.AccountLoginAuthPassword, UUID> {

}
