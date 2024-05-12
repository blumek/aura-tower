package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import com.tower.aura.api.authentication.model.*;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.RefreshTokenCreator;
import com.tower.aura.spi.encryption.PasswordValidator;
import com.tower.aura.spi.persistence.user.authentication.*;
import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;
import com.tower.aura.spi.persistence.user.authentication.model.PersistencePassword;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class LogInUserService implements LogInUserUseCase {
    private final UserCredentialsQueryGateway userCredentialsQueryGateway;
    private final PasswordValidator passwordValidator;
    private final AccessTokenCreator accessTokenCreator;
    private final RefreshTokenCreator refreshTokenCreator;
    private final RefreshTokenPersistenceGateway refreshTokenPersistenceGateway;

    LogInUserService(UserCredentialsQueryGateway userCredentialsQueryGateway,
                     PasswordValidator passwordValidator,
                     AccessTokenCreator accessTokenCreator,
                     RefreshTokenCreator refreshTokenCreator,
                     RefreshTokenPersistenceGateway refreshTokenPersistenceGateway) {
        this.userCredentialsQueryGateway = userCredentialsQueryGateway;
        this.passwordValidator = passwordValidator;
        this.accessTokenCreator = accessTokenCreator;
        this.refreshTokenCreator = refreshTokenCreator;
        this.refreshTokenPersistenceGateway = refreshTokenPersistenceGateway;
    }

    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        final var userCredentialsQueryReply = findUserCredentials(logInUserRequest);

        final var generatedJsonWebTokenPair = generateJwtTokenPair(userCredentialsQueryReply);
        persistRefreshToken(generatedJsonWebTokenPair);

        return new LogInUserReply(generatedJsonWebTokenPair);
    }

    private UserCredentialsQueryReply findUserCredentials(LogInUserRequest logInUserRequest) {
        final var username = new PersistenceUsername(logInUserRequest.username().value());
        final var userCredentialsQueryReply = findUserCredentialsByUsername(username);
        if (passwordsMatch(logInUserRequest.password(), userCredentialsQueryReply.password())) {
            throw new IllegalArgumentException("Username or password does not match");
        }
        return userCredentialsQueryReply;
    }

    private UserCredentialsQueryReply findUserCredentialsByUsername(PersistenceUsername username) {
        try {
            return userCredentialsQueryGateway.findByUsername(username);
        } catch (UserCredentialsNotFoundException exception) {
            throw new IllegalArgumentException("Username or password does not match");
        }
    }

    private boolean passwordsMatch(ApiPassword password, PersistencePassword anotherPassword) {
        return !passwordValidator.matches(password, new ApiPassword(anotherPassword.value()));
    }

    private ApiJsonWebTokenPair generateJwtTokenPair(UserCredentialsQueryReply userCredentialsQueryReply) {
        final var accessToken = accessTokenCreator.create(new AccessTokenCreateRequest(
                new ApiUserIdentifier(userCredentialsQueryReply.userIdentifier().value()),
                new ApiUsername(userCredentialsQueryReply.username().value())
        ));
        final var refreshToken = refreshTokenCreator.create();
        return new ApiJsonWebTokenPair(accessToken, refreshToken);
    }

    private void persistRefreshToken(ApiJsonWebTokenPair jsonWebTokenPair) {
        refreshTokenPersistenceGateway.persist(toRefreshTokenPersistenceRequest(jsonWebTokenPair));
    }

    private static RefreshTokenPersistenceRequest toRefreshTokenPersistenceRequest(ApiJsonWebTokenPair jsonWebTokenPair) {
        return new RefreshTokenPersistenceRequest(
                new PersistenceJsonWebToken(jsonWebTokenPair.refreshToken().value()),
                new PersistenceJsonWebToken(jsonWebTokenPair.accessToken().value())
        );
    }
}
