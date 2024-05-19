package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.model.ApiUserIdentifier;

public record ChangePasswordRequest(ApiUserIdentifier userIdentifier,
                                    ApiPassword oldPassword,
                                    ApiPassword newPassword) {
    public ChangePasswordRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (oldPassword == null) {
            throw new IllegalArgumentException("Old password cannot be null");
        }

        if (newPassword == null) {
            throw new IllegalArgumentException("New password cannot be null");
        }
    }
}
