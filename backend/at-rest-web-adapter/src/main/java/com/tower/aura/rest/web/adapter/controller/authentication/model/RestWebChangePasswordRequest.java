package com.tower.aura.rest.web.adapter.controller.authentication.model;

import com.tower.aura.api.authentication.ChangePasswordRequest;
import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;

import static org.apache.commons.lang3.StringUtils.isBlank;

public record RestWebChangePasswordRequest(String oldPassword,
                                           String newPassword) {
    public RestWebChangePasswordRequest {
        if (isBlank(oldPassword)) {
            throw new IllegalArgumentException("Old password cannot be blank");
        }

        if (isBlank(newPassword)) {
            throw new IllegalArgumentException("New password cannot be blank");
        }
    }

    public ChangePasswordRequest toChangePasswordRequestWithUserIdentifier(String userIdentifier) {
        return new ChangePasswordRequest(
                new ApiUserIdentifier(userIdentifier),
                new ApiPassword(oldPassword),
                new ApiPassword(newPassword)
        );
    }
}
