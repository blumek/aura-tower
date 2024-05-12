package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<RefreshTokenDocument> findByRefreshToken(String refreshToken) {
        return repository.findById(refreshToken);
    }
}
