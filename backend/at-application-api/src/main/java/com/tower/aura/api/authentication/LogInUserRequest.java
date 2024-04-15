package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.authentication.model.ApiUsername;

public record LogInUserRequest(ApiUsername username,
                               ApiPassword password) {
    public LogInUserRequest {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }
}
