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
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import com.tower.aura.spi.authentication.jwt.JwtTokenPairCreator;

public class RefreshTokenService implements RefreshTokenUseCase {
    private final JWTVerifier jwtVerifier;
    private final JwtTokenPairCreator jwtTokenPairCreator;

    public RefreshTokenService(JWTVerifier jwtVerifier, JwtTokenPairCreator jwtTokenPairCreator) {
        this.jwtVerifier = jwtVerifier;
        this.jwtTokenPairCreator = jwtTokenPairCreator;
    }

    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        validateRefreshToken(refreshTokenRequest.tokenPair().refreshToken());

        return new RefreshTokenReply(generateJwtTokenPair(refreshTokenRequest.tokenPair().accessToken()));
    }

    private void validateRefreshToken(ApiJsonWebToken refreshToken) {
        try {
            jwtVerifier.verify(refreshToken.value());
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("Invalid refresh token");
        }
    }

    private ApiJsonWebTokenPair generateJwtTokenPair(ApiJsonWebToken accessToken) {
        final var decodedAccessToken = JWT.decode(accessToken.value());
        final var userIdentifier = decodedAccessToken.getClaim("user_id").asString();
        final var username = decodedAccessToken.getClaim("username").asString();
        return jwtTokenPairCreator.create(new JwtCreateRequest(
                new ApiUserIdentifier(userIdentifier),
                new ApiUsername(username)
        ));
    }
}
