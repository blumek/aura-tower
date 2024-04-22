package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.UsernameQueryGateway;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class MongodbUsernameQueryGateway implements UsernameQueryGateway {
    private final MongodbUserCredentialsRepository userCredentialsRepository;

    MongodbUsernameQueryGateway(MongodbUserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public boolean exists(PersistenceUsername username) {
        return userCredentialsRepository.usernameExists(username.value());
    }
}
