package com.deevscale.principalapi.entity.login;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "account_application_login")
@Getter
@Builder
public class AccountApplicationLogin extends BaseEntity {


    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "application_id")
    private UUID applicationId;

    @Column(name = "account_login_id")
    private UUID accountLoginId;


    @Entity
    @Getter
    @Builder
    @Table(name = "account_login_auth_password")
    public static class AccountLoginAuthPassword extends BaseEntity {

        @Basic(optional = true, fetch = FetchType.LAZY)
        @Column(name = "password", nullable = true)
        private String password;

        @Column(name = "account_login_id")
        private UUID accountLoginId;

    }
}
