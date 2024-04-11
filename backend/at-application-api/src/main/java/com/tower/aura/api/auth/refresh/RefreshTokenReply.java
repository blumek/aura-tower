package com.tower.aura.api.auth.refresh;

import com.tower.aura.api.auth.model.ApiJsonWebTokenPair;

public record RefreshTokenReply(ApiJsonWebTokenPair tokenPair) {
    public RefreshTokenReply {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
