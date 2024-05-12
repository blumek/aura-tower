package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.UserCredentialsNotFoundException;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryReply;
import com.tower.aura.spi.persistence.user.authentication.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class MongodbUserCredentialsQueryGateway implements UserCredentialsQueryGateway {
    private final MongodbUserCredentialsRepository userCredentialsRepository;

    public MongodbUserCredentialsQueryGateway(MongodbUserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public UserCredentialsQueryReply findByUsername(PersistenceUsername username) {
        return userCredentialsRepository.findByUsername(username.value())
                .map(this::toUserCredentialsQueryReply)
                .orElseThrow(() -> new UserCredentialsNotFoundException(username));
    }

    private UserCredentialsQueryReply toUserCredentialsQueryReply(UserCredentialsDocument userCredentials) {
        return new UserCredentialsQueryReply(
                new PersistenceUserIdentifier(userCredentials.getUserIdentifier()),
                new PersistenceUsername(userCredentials.getUsername()),
                new PersistencePassword(userCredentials.getPassword())
        );
    }
}
