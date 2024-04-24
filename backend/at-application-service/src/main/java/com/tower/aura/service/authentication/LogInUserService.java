package com.tower.aura.service.authentication;

import com.tower.aura.api.authentication.LogInUserReply;
import com.tower.aura.api.authentication.LogInUserRequest;
import com.tower.aura.api.authentication.LogInUserUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.api.authentication.model.ApiPassword;
import com.tower.aura.spi.encryption.PasswordValidator;
import com.tower.aura.spi.persistence.user.authentication.UserCredentialsQueryGateway;
import com.tower.aura.spi.persistence.user.model.PersistenceUsername;
import org.springframework.stereotype.Service;

@Service
class LogInUserService implements LogInUserUseCase {
    private final UserCredentialsQueryGateway userCredentialsQueryGateway;
    private final PasswordValidator passwordValidator;

    LogInUserService(UserCredentialsQueryGateway userCredentialsQueryGateway,
                     PasswordValidator passwordValidator) {
        this.userCredentialsQueryGateway = userCredentialsQueryGateway;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public LogInUserReply logIn(LogInUserRequest logInUserRequest) {
        final var username = new PersistenceUsername(logInUserRequest.username().value());
        final var userCredentialsQueryReply = userCredentialsQueryGateway.findByUsername(username);
        if (!passwordValidator.matches(logInUserRequest.password(), new ApiPassword(userCredentialsQueryReply.password().value()))) {
            throw new IllegalArgumentException("Password does not match");
        }

        return new LogInUserReply(new ApiJsonWebTokenPair(new ApiJsonWebToken("accessToken"), new ApiJsonWebToken("refreshToken")));
    }
}
