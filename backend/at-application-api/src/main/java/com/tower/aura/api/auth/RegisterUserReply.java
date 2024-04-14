package com.tower.aura.api.auth;

import com.tower.aura.api.auth.model.ApiUserIdentifier;

public record RegisterUserReply(ApiUserIdentifier userIdentifier) {
    public RegisterUserReply {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }
    }
}
