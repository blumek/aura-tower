package com.tower.aura.service.authentication.jwt;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record JwtConfiguration(String secret, Duration expirationTime) {
    public JwtConfiguration {
        if (isBlank(secret)) {
            throw new IllegalArgumentException("Secret cannot be blank");
        }

        if (expirationTime == null) {
            throw new IllegalArgumentException("Expiration time cannot be null");
        }
    }
}
