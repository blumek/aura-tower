package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;

public record RefreshTokenPersistenceRequest(PersistenceJsonWebToken refreshToken,
                                             PersistenceJsonWebToken accessToken) {
    public RefreshTokenPersistenceRequest {
        if (refreshToken == null) {
            throw new IllegalArgumentException("Refresh token cannot be null");
        }

        if (accessToken == null) {
            throw new IllegalArgumentException("Access token cannot be null");
        }
    }
}
