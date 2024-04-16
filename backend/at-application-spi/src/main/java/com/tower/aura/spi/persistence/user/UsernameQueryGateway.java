package com.tower.aura.spi.persistence.user;

import com.tower.aura.spi.persistence.user.model.PersistenceUsername;

public interface UsernameQueryGateway {
    boolean exists(PersistenceUsername username);
}
