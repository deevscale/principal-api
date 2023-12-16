package com.deevscale.principalapi.entity.profile;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Builder
public class AccountProfile extends BaseEntity {


    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "application_id")
    private UUID applicationId;

    @Column(name = "first_name")
    private String firstName;

}
