package com.tower.aura.api.auth.login;

import com.tower.aura.api.auth.model.ApiJsonWebToken;

public record LogInUserReply(ApiJsonWebToken token) {
    public LogInUserReply {
        if (token == null) {
            throw new IllegalArgumentException("Token cannot be null");
        }
    }
}
