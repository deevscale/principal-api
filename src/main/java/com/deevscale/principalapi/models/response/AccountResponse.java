package com.deevscale.principalapi.models.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AccountResponse(
        UUID id,
        String username
) {
}
