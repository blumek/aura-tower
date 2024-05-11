package com.tower.aura.service.authentication.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.isBlank;

@ConfigurationProperties(prefix = "aura-tower.security.jwt")
public record JwtConfiguration(String secret,
                               Duration accessTokenExpirationTime,
                               Duration refreshTokenExpirationTime) {
    public JwtConfiguration {
        if (isBlank(secret)) {
            throw new IllegalArgumentException("Secret cannot be blank");
        }

        if (accessTokenExpirationTime == null) {
            throw new IllegalArgumentException("Access token Expiration time cannot be null");
        }

        if (refreshTokenExpirationTime == null) {
            throw new IllegalArgumentException("Refresh token Expiration time cannot be null");
        }
    }
}