package com.tower.aura.api.auth;

import com.tower.aura.api.auth.model.ApiJsonWebTokenPair;

public record RefreshTokenRequest(ApiJsonWebTokenPair tokenPair) {
    public RefreshTokenRequest {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
