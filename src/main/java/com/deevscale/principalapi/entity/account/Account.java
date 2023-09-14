package com.deevscale.principalapi.entity.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

import java.util.UUID;

@Entity(name = "account")
@Builder
public record Account(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        UUID id,
        String username,
        String password
) {
}
