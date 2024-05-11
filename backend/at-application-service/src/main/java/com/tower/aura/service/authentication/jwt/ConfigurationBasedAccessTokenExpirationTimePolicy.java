package com.tower.aura.service.authentication.jwt;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
class ConfigurationBasedAccessTokenExpirationTimePolicy implements JwtExpirationTimePolicy {
    private final Duration expirationTime;

    ConfigurationBasedAccessTokenExpirationTimePolicy(JwtConfiguration jwtConfiguration) {
        this.expirationTime = jwtConfiguration.accessTokenExpirationTime();
    }

    @Override
    public Duration expirationTime() {
        return expirationTime;
    }
}
