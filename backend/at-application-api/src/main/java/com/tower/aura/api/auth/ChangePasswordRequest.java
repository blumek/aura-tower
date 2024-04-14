package com.tower.aura.api.auth;

import com.tower.aura.api.auth.model.ApiPassword;
import com.tower.aura.api.auth.model.ApiUserIdentifier;

public record ChangePasswordRequest(ApiUserIdentifier userIdentifier,
                                    ApiPassword password) {
    public ChangePasswordRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }
}
