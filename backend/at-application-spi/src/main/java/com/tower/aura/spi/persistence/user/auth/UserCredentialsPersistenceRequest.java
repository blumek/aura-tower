package com.tower.aura.spi.persistence.user.auth;

import com.tower.aura.spi.persistence.user.auth.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.auth.model.PersistenceUsername;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;

public record UserCredentialsPersistenceRequest(PersistenceUserIdentifier userIdentifier,
                                                PersistenceUsername username,
                                                PersistencePassword password) {
    public UserCredentialsPersistenceRequest {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }

        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
    }
}
