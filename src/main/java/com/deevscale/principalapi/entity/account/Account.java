package com.deevscale.principalapi.entity.account;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "account")
public class Account extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Builder
    public Account(String username, UUID id, UUID createdBy, Instant createdAt, UUID modifiedBy, Instant modifiedAt, UUID deletedBy, Instant deletedAt) {
        super(id, createdBy, createdAt, modifiedBy, modifiedAt, deletedBy, deletedAt);
        this.username = username;

    }

}
