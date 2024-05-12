package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import org.springframework.stereotype.Service;

@Service
class DefaultMongodbRefreshTokenRepository implements MongodbRefreshTokenRepository {
    private final SpringMongodbRefreshTokenRepository repository;

    DefaultMongodbRefreshTokenRepository(SpringMongodbRefreshTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public RefreshTokenDocument save(RefreshTokenDocument refreshTokenDocument) {
        return repository.save(refreshTokenDocument);
    }
}
