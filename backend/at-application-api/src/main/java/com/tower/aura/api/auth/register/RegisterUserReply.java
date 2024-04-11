package com.tower.aura.api.auth.register;

import com.tower.aura.api.auth.model.ApiJsonWebToken;

public record RegisterUserReply(ApiJsonWebToken token) {
    public RegisterUserReply {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }
    }
}
