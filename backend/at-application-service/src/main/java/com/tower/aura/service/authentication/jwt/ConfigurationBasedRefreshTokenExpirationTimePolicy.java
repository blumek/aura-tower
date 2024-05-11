package com.tower.aura.service.authentication.jwt;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
class ConfigurationBasedRefreshTokenExpirationTimePolicy implements JwtExpirationTimePolicy {
    private final Duration expirationTime;

    ConfigurationBasedRefreshTokenExpirationTimePolicy(JwtConfiguration jwtConfiguration) {
        this.expirationTime = jwtConfiguration.refreshTokenExpirationTime();
    }

    @Override
    public Duration expirationTime() {
        return expirationTime;
    }
}
