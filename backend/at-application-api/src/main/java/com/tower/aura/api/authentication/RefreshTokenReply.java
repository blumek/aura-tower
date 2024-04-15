package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

public record RefreshTokenReply(ApiJsonWebTokenPair tokenPair) {
    public RefreshTokenReply {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
