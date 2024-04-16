package com.tower.aura.application.persistence.mongodb.adapter.user.authentication;

import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceReply;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceRequest;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import org.springframework.stereotype.Service;

@Service
class MongodbUserCredentialsPersistenceGateway implements UserCredentialsPersistenceGateway {
    private final MongodbUserCredentialsRepository userCredentialsRepository;

    MongodbUserCredentialsPersistenceGateway(MongodbUserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public UserCredentialsPersistenceReply persist(UserCredentialsPersistenceRequest userCredentialsPersistenceRequest) {
        final var savedUserCredentialsDocument = userCredentialsRepository.save(toUserCredentials(userCredentialsPersistenceRequest));
        return toUserCredentialsPersistenceReply(savedUserCredentialsDocument);
    }

    private UserCredentialsDocument toUserCredentials(UserCredentialsPersistenceRequest userCredentialsPersistenceRequest) {
        return new UserCredentialsDocument(
                userCredentialsPersistenceRequest.userIdentifier().value(),
                userCredentialsPersistenceRequest.username().value(),
                userCredentialsPersistenceRequest.password().value()
        );
    }

    private UserCredentialsPersistenceReply toUserCredentialsPersistenceReply(UserCredentialsDocument savedUserCredentialsDocument) {
        return new UserCredentialsPersistenceReply(new PersistenceUserIdentifier(savedUserCredentialsDocument.getUserIdentifier()));
    }
}
