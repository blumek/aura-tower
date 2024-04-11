package com.tower.aura.api.auth.register;

import com.tower.aura.api.auth.model.JsonWebToken;

public record RegisterUserReply(JsonWebToken token) {
    public RegisterUserReply {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }
    }
}
