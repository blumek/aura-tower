package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;

public record UserCredentialsQueryReply(PersistenceUserIdentifier userIdentifier,
                                        PersistenceUsername username,
                                        PersistencePassword password) {
    public UserCredentialsQueryReply {
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
