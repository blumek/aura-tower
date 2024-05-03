package com.tower.aura.service.authentication.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.isBlank;

@ConfigurationProperties(prefix = "aura-tower.security.jwt")
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