package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.RegisterUserReply;
import com.tower.aura.api.authentication.RegisterUserRequest;
import com.tower.aura.api.authentication.RegisterUserUseCase;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;
import com.tower.aura.spi.persistence.user.UsernameQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceReply;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceRequest;
import com.tower.aura.spi.persistence.user.authentication.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class RegisterUserService implements RegisterUserUseCase {
    private final UsernameQueryGateway usernameQueryGateway;
    private final UserCredentialsPersistenceGateway userCredentialsPersistenceGateway;

    RegisterUserService(UsernameQueryGateway usernameQueryGateway,
                        UserCredentialsPersistenceGateway userCredentialsPersistenceGateway) {
        this.usernameQueryGateway = usernameQueryGateway;
        this.userCredentialsPersistenceGateway = userCredentialsPersistenceGateway;
    }

    @Override
    public RegisterUserReply register(RegisterUserRequest registerUserRequest) {
        if (usernameAlreadyExists(registerUserRequest)) {
            throw new IllegalArgumentException("Username already exists");
        }

        final var persistenceReply = userCredentialsPersistenceGateway.persist(toUserCredentialsPersistenceRequest(registerUserRequest));
        return toRegisterUserReply(persistenceReply);
    }

    private boolean usernameAlreadyExists(RegisterUserRequest registerUserRequest) {
        return usernameQueryGateway.exists(new PersistenceUsername(registerUserRequest.username().value()));
    }

    private UserCredentialsPersistenceRequest toUserCredentialsPersistenceRequest(RegisterUserRequest registerUserRequest) {
        return new UserCredentialsPersistenceRequest(
                new PersistenceUserIdentifier(UUID.randomUUID().toString()),
                new PersistenceUsername(registerUserRequest.username().value()),
                new PersistencePassword(registerUserRequest.password().value())
        );
    }

    private RegisterUserReply toRegisterUserReply(UserCredentialsPersistenceReply persistenceReply) {
        return new RegisterUserReply(
                new ApiUserIdentifier(persistenceReply.userIdentifier().value())
        );
    }
}
