package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;
import com.tower.aura.api.authentication.model.ApiUsername;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.RefreshTokenCreator;
import com.tower.aura.spi.encryption.PasswordValidator;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryReply;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class LogInUserService implements LogInUserUseCase {
    private final UserCredentialsQueryGateway userCredentialsQueryGateway;
    private final PasswordValidator passwordValidator;
    private final AccessTokenCreator accessTokenCreator;
    private final RefreshTokenCreator refreshTokenCreator;

    LogInUserService(UserCredentialsQueryGateway userCredentialsQueryGateway,
                     PasswordValidator passwordValidator,
                     AccessTokenCreator accessTokenCreator,
                     RefreshTokenCreator refreshTokenCreator) {
        this.userCredentialsQueryGateway = userCredentialsQueryGateway;
        this.passwordValidator = passwordValidator;
        this.accessTokenCreator = accessTokenCreator;
        this.refreshTokenCreator = refreshTokenCreator;
    }

    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        final var username = new PersistenceUsername(logInUserRequest.username().value());
        final var userCredentialsQueryReply = userCredentialsQueryGateway.findByUsername(username);
        if (passwordAlreadyExists(logInUserRequest.password(), userCredentialsQueryReply)) {
            throw new IllegalArgumentException("Password does not match");
        }

        return new LogInUserReply(generateJwtTokenPair(userCredentialsQueryReply));
    }

    private boolean passwordAlreadyExists(ApiPassword password, UserCredentialsQueryReply userCredentialsQueryReply) {
        return !passwordValidator.matches(password, new ApiPassword(userCredentialsQueryReply.password().value()));
    }

    private ApiJsonWebTokenPair generateJwtTokenPair(UserCredentialsQueryReply userCredentialsQueryReply) {
        final var accessToken =  accessTokenCreator.create(new AccessTokenCreateRequest(
                new ApiUserIdentifier(userCredentialsQueryReply.userIdentifier().value()),
                new ApiUsername(userCredentialsQueryReply.username().value())
        ));
        final var refreshToken = refreshTokenCreator.create();
        return new ApiJsonWebTokenPair(accessToken, refreshToken);
    }
}
