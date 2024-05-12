package com.tower.aura.service.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tower.aura.api.authentication.RefreshTokenReply;
import com.tower.aura.api.authentication.RefreshTokenRequest;
import com.tower.aura.api.authentication.RefreshTokenUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.api.authentication.model.ApiUserIdentifier;
import com.tower.aura.api.authentication.model.ApiUsername;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;

public class RefreshTokenService implements RefreshTokenUseCase {
    private final JWTVerifier jwtVerifier;
    private final AccessTokenCreator accessTokenCreator;

    public RefreshTokenService(JWTVerifier jwtVerifier, AccessTokenCreator accessTokenCreator) {
        this.jwtVerifier = jwtVerifier;
        this.accessTokenCreator = accessTokenCreator;
    }

    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        validateRefreshToken(refreshTokenRequest.tokenPair().refreshToken());

        return new RefreshTokenReply(generateNewJsonWebTokenPair(refreshTokenRequest));
    }

    private void validateRefreshToken(ApiJsonWebToken refreshToken) {
        try {
            jwtVerifier.verify(refreshToken.value());
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("Invalid refresh token");
        }
    }

    private ApiJsonWebTokenPair generateNewJsonWebTokenPair(RefreshTokenRequest refreshTokenRequest) {
        final var decodedAccessToken = JWT.decode(refreshTokenRequest.tokenPair().accessToken().value());
        final var userIdentifier = decodedAccessToken.getClaim("user_id").asString();
        final var username = decodedAccessToken.getClaim("username").asString();
        final var newAccessToken =  accessTokenCreator.create(new AccessTokenCreateRequest(
                new ApiUserIdentifier(userIdentifier),
                new ApiUsername(username)
        ));

        return new ApiJsonWebTokenPair(newAccessToken, refreshTokenRequest.tokenPair().refreshToken());
    }
}
