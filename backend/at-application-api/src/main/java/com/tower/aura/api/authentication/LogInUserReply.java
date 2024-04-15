package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;

public record LogInUserReply(ApiJsonWebTokenPair tokenPair) {
    public LogInUserReply {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
