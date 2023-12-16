package com.deevscale.principalapi.entity.login;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "account_login")
@Getter
@Builder
public class AccountLogin extends BaseEntity {


    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "username")
    private String username;


}
