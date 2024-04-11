package com.tower.aura.api.auth.login;

import com.tower.aura.api.auth.model.ApiJsonWebTokenPair;

public record LogInUserReply(ApiJsonWebTokenPair tokenPair) {
    public LogInUserReply {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
