package com.tower.aura.api.auth;

import com.tower.aura.api.auth.model.ApiForgotPassword;
import com.tower.aura.api.auth.model.ApiPassword;
import com.tower.aura.api.auth.model.ApiUsername;

public record RegisterUserRequest(ApiUsername username,
                                  ApiPassword password,
                                  ApiForgotPassword forgotPassword) {
    public RegisterUserRequest {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (forgotPassword == null) {
            throw new IllegalArgumentException("Forgot value cannot be null");
        }
    }
}
