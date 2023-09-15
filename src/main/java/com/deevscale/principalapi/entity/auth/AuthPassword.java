package com.deevscale.principalapi.entity.auth;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@Table(name = "auth_password")
public class AuthPassword extends BaseEntity {

        @Column(name = "password")
        private String password;

        @Column(name = "account_id")
        private UUID accountId;

}
