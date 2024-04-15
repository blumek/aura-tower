package com.tower.aura.spi.persistence.user.authentication;

public interface UserCredentialsPersistenceGateway {
    UserCredentialsPersistenceReply persist(UserCredentialsPersistenceRequest userCredentialsPersistenceRequest);
}
