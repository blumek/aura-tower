package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import java.util.Optional;

interface MongodbRefreshTokenRepository {
    RefreshTokenDocument save(RefreshTokenDocument refreshTokenDocument);
    Optional<RefreshTokenDocument> findByRefreshToken(String refreshToken);
}
