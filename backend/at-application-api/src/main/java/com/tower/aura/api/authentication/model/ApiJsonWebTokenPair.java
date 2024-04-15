package com.tower.aura.api.authentication.model;

public record ApiJsonWebTokenPair(ApiJsonWebToken accessToken,
                                  ApiJsonWebToken refreshToken) {
    public ApiJsonWebTokenPair {
        if (accessToken == null) {
            throw new IllegalArgumentException("Access token cannot be null");
        }

        if (refreshToken == null) {
            throw new IllegalArgumentException("Refresh token cannot be null");
        }
    }
}
