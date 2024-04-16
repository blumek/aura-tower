package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.UsernameQueryGateway;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class MongodbUsernameQueryGateway implements UsernameQueryGateway {
    @Override
    public boolean exists(PersistenceUsername username) {
        return false;
    }
}
