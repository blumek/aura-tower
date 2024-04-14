package com.tower.aura.spi.persistence.user.auth;

public interface UserCredentialsPersistenceGateway {
    UserCredentialsPersistenceReply persist(UserCredentialsPersistenceRequest userCredentialsPersistenceRequest);
}
