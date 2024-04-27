package com.tower.aura.api.authentication;

import com.tower.aura.api.authentication.model.ApiJsonWebToken;

public record ValidateAccessTokenRequest(ApiJsonWebToken accessToken) {
    public ValidateAccessTokenRequest {
        if (accessToken == null) {
            throw new IllegalArgumentException("Access token cannot be null");
        }
    }
}
