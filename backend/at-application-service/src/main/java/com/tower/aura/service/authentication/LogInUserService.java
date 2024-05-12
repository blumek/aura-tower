package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import com.tower.aura.api.authentication.model.*;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.RefreshTokenCreator;
import com.tower.aura.spi.encryption.PasswordValidator;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceRequest;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryReply;
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
        final var username = new PersistenceUsername(logInUserRequest.username().value());
        final var userCredentialsQueryReply = userCredentialsQueryGateway.findByUsername(username);
        if (passwordsMatch(logInUserRequest.password(), userCredentialsQueryReply.password())) {
            throw new IllegalArgumentException("Password does not match");
        }

        final var generatedJsonWebTokenPair = generateJwtTokenPair(userCredentialsQueryReply);
        persistRefreshToken(generatedJsonWebTokenPair);

        return new LogInUserReply(generatedJsonWebTokenPair);
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
