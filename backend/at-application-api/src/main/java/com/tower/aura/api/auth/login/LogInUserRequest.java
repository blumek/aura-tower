package com.tower.aura.api.auth.login;

import com.tower.aura.api.auth.model.ApiPassword;
import com.tower.aura.api.auth.model.ApiUsername;

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
