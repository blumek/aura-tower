package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;

public interface RefreshTokenQueryGateway {
    RefreshTokenQueryReply findJsonWebTokenPairByRefreshToken(PersistenceJsonWebToken refreshToken);
}
