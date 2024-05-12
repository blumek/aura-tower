package com.tower.aura.spi.persistence.user.authentication;

public interface RefreshTokenPersistenceGateway {
    void persist(RefreshTokenPersistenceRequest refreshTokenPersistenceRequest);
}
