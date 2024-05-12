package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;

public record RefreshTokenQueryReply(PersistenceJsonWebToken refreshToken,
                                     PersistenceJsonWebToken accessToken) {
    public RefreshTokenQueryReply {
        if (refreshToken == null) {
            throw new IllegalArgumentException("Refresh token cannot be null");
        }

        if (accessToken == null) {
            throw new IllegalArgumentException("Access token cannot be null");
        }
    }
}
