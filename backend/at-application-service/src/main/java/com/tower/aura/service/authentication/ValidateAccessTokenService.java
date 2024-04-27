package com.tower.aura.service.authentication;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tower.aura.api.authentication.ValidateAccessTokenRequest;
import com.tower.aura.api.authentication.ValidateAccessTokenResponse;
import com.tower.aura.api.authentication.ValidateAccessTokenUseCase;
import org.springframework.stereotype.Service;

@Service
class ValidateAccessTokenService implements ValidateAccessTokenUseCase {
    private final JWTVerifier jwtVerifier;

    ValidateAccessTokenService(JWTVerifier jwtVerifier) {
        this.jwtVerifier = jwtVerifier;
    }

    @Override
    public ValidateAccessTokenResponse validate(ValidateAccessTokenRequest validateAccessTokenRequest) {
        try {
            jwtVerifier.verify(validateAccessTokenRequest.accessToken().value());
            return new ValidateAccessTokenResponse(true);
        } catch (JWTVerificationException exception) {
            return new ValidateAccessTokenResponse(false);
        }
    }
}
