package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

interface MongodbRefreshTokenRepository {
    RefreshTokenDocument save(RefreshTokenDocument refreshTokenDocument);
}
