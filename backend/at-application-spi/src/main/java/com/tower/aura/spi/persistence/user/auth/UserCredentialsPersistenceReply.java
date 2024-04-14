package com.tower.aura.spi.persistence.user.auth;

import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;

public record UserCredentialsPersistenceReply(PersistenceUserIdentifier userIdentifier) {
    public UserCredentialsPersistenceReply {
        if (userIdentifier == null) {
            throw new IllegalArgumentException("User identifier cannot be null");
        }
    }
}
