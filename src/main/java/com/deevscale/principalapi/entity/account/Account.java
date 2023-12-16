package com.deevscale.principalapi.entity.account;

import com.deevscale.principalapi.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "account")
@Getter
@Builder
public class Account extends BaseEntity {


}
