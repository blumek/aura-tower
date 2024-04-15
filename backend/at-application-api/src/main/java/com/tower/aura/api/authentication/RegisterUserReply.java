package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiUserIdentifier;

public record RegisterUserReply(ApiUserIdentifier userIdentifier) {
    public RegisterUserReply {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }
    }
}
