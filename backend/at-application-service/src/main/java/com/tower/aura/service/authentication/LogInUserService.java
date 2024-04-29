package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import com.tower.aura.api.authentication.model.*;
import com.tower.aura.spi.authentication.jwt.JwtTokenPairCreator;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import com.tower.aura.spi.encryption.PasswordValidator;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryReply;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class LogInUserService implements LogInUserUseCase {
    private final UserCredentialsQueryGateway userCredentialsQueryGateway;
    private final PasswordValidator passwordValidator;
    private final JwtTokenPairCreator jwtTokenPairCreator;

    LogInUserService(UserCredentialsQueryGateway userCredentialsQueryGateway,
                     PasswordValidator passwordValidator,
                     JwtTokenPairCreator jwtTokenPairCreator) {
        this.userCredentialsQueryGateway = userCredentialsQueryGateway;
        this.passwordValidator = passwordValidator;
        this.jwtTokenPairCreator = jwtTokenPairCreator;
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
        return jwtTokenPairCreator.create(new JwtCreateRequest(
                new ApiUserIdentifier(userCredentialsQueryReply.userIdentifier().value()),
                new ApiUsername(userCredentialsQueryReply.username().value())
        ));
    }
}
