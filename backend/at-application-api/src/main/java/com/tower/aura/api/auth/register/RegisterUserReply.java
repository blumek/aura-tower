package com.tower.aura.api.auth.register;

import com.tower.aura.api.auth.model.ApiJsonWebTokenPair;

public record RegisterUserReply(ApiJsonWebTokenPair tokenPair) {
    public RegisterUserReply {
        if (tokenPair == null) {
            throw new IllegalArgumentException("Token pair cannot be null");
        }
    }
}
