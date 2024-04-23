package com.tower.aura.spi.persistence.user.authentication;

import com.tower.aura.spi.persistence.user.model.PersistenceUsername;

public interface UserCredentialsQueryGateway {
    UserCredentialsQueryReply findByUsername(PersistenceUsername username);
}
