package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

public record RefreshTokenRequest(ApiJsonWebTokenPair tokenPair) {
    public RefreshTokenRequest {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
