package com.tower.aura.service.authentication.jwt;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
class ConfigurationBasedJwtExpirationTimePolicy implements JwtExpirationTimePolicy {
    private final Duration expirationTime;

    ConfigurationBasedJwtExpirationTimePolicy(JwtConfiguration jwtConfiguration) {
        this.expirationTime = jwtConfiguration.expirationTime();
    }

    @Override
    public Duration expirationTime() {
        return expirationTime;
    }
}
