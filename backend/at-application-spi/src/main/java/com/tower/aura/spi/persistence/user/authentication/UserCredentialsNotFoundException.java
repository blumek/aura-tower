package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.model.PersistenceUsername;

public class UserCredentialsNotFoundException extends RuntimeException {
    public UserCredentialsNotFoundException(PersistenceUsername username) {
        super("No user credentials for %s found".formatted(username.value()));
    }
}
