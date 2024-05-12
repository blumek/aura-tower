package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceRequest;
import org.springframework.stereotype.Service;

@Service
class MongodbRefreshTokenPersistenceGateway implements RefreshTokenPersistenceGateway {
    private final MongodbRefreshTokenRepository repository;

    MongodbRefreshTokenPersistenceGateway(MongodbRefreshTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void persist(RefreshTokenPersistenceRequest refreshTokenPersistenceRequest) {
        repository.save(toRefreshTokenDocument(refreshTokenPersistenceRequest));
    }

    private static RefreshTokenDocument toRefreshTokenDocument(RefreshTokenPersistenceRequest refreshTokenPersistenceRequest) {
        return new RefreshTokenDocument(
                refreshTokenPersistenceRequest.refreshToken().value(),
                refreshTokenPersistenceRequest.accessToken().value()
        );
    }
}
