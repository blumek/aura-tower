package com.tower.aura.api.auth.login;

import com.tower.aura.api.auth.model.JsonWebToken;

public record LogInUserReply(JsonWebToken token) {
    public LogInUserReply {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }
    }
}
