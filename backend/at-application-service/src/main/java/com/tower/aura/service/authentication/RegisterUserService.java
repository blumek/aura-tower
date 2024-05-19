package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.RegisterUserReply;
import com.tower.aura.api.authentication.RegisterUserRequest;
import com.tower.aura.api.authentication.RegisterUserUseCase;
import com.tower.aura.api.model.ApiUserIdentifier;
import com.tower.aura.spi.encryption.PasswordEncrypter;
import com.tower.aura.spi.persistence.user.UsernameQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceReply;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsPersistenceRequest;
import com.tower.aura.spi.persistence.user.authentication.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.model.PersistenceUserIdentifier;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class RegisterUserService implements RegisterUserUseCase {
    private final UsernameQueryGateway usernameQueryGateway;
    private final PasswordEncrypter passwordEncrypter;
    private final UserCredentialsPersistenceGateway userCredentialsPersistenceGateway;

    RegisterUserService(UsernameQueryGateway usernameQueryGateway,
                        PasswordEncrypter passwordEncrypter,
                        UserCredentialsPersistenceGateway userCredentialsPersistenceGateway) {
        this.usernameQueryGateway = usernameQueryGateway;
        this.passwordEncrypter = passwordEncrypter;
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
        final var encryptedPassword = passwordEncrypter.encrypt(registerUserRequest.password());
        return new UserCredentialsPersistenceRequest(
                new PersistenceUserIdentifier(UUID.randomUUID().toString()),
                new PersistenceUsername(registerUserRequest.username().value()),
                new PersistencePassword(encryptedPassword.value())
        );
    }

    private RegisterUserReply toRegisterUserReply(UserCredentialsPersistenceReply persistenceReply) {
        return new RegisterUserReply(
                new ApiUserIdentifier(persistenceReply.userIdentifier().value())
        );
    }
}
