package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.RefreshTokenQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenQueryReply;
import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;
import org.springframework.stereotype.Service;

@Service
class MongodbRefreshTokenQueryGateway implements RefreshTokenQueryGateway {
    private final MongodbRefreshTokenRepository repository;

    MongodbRefreshTokenQueryGateway(MongodbRefreshTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public RefreshTokenQueryReply findJsonWebTokenPairByRefreshToken(PersistenceJsonWebToken refreshToken) {
        return repository.findByRefreshToken(refreshToken.value())
                .map(this::toRefreshTokenQueryReply)
                .orElseThrow(() -> new IllegalArgumentException("No json web token pair for refresh token: %s".formatted(refreshToken.value())));
    }

    private RefreshTokenQueryReply toRefreshTokenQueryReply(RefreshTokenDocument refreshTokenDocument) {
        return new RefreshTokenQueryReply(
                new PersistenceJsonWebToken(refreshTokenDocument.getRefreshToken()),
                new PersistenceJsonWebToken(refreshTokenDocument.getAccessToken())
        );
    }
}
