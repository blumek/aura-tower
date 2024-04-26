package com.tower.aura.spi.authentication.jwt;

import com.tower.aura.api.authentication.model.ApiUserIdentifier;
import com.tower.aura.api.authentication.model.ApiUsername;

public record JwtCreateRequest(ApiUserIdentifier userIdentifier, ApiUsername username) {
    public JwtCreateRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }
    }
}
