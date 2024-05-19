package com.tower.aura.service.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tower.aura.api.authentication.RefreshTokenReply;
import com.tower.aura.api.authentication.RefreshTokenRequest;
import com.tower.aura.api.authentication.RefreshTokenUseCase;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.api.model.ApiUserIdentifier;
import com.tower.aura.api.authentication.model.ApiUsername;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreateRequest;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceGateway;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenPersistenceRequest;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenQueryGateway;
import com.tower.aura.spi.persistence.user.authentication.RefreshTokenQueryReply;
import com.tower.aura.spi.persistence.user.authentication.model.PersistenceJsonWebToken;

import java.util.Objects;

public class RefreshTokenService implements RefreshTokenUseCase {
    private final JWTVerifier jwtVerifier;
    private final RefreshTokenQueryGateway refreshTokenQueryGateway;
    private final AccessTokenCreator accessTokenCreator;
    private final RefreshTokenPersistenceGateway refreshTokenPersistenceGateway;

    public RefreshTokenService(JWTVerifier jwtVerifier,
                               RefreshTokenQueryGateway refreshTokenQueryGateway,
                               AccessTokenCreator accessTokenCreator,
                               RefreshTokenPersistenceGateway refreshTokenPersistenceGateway) {
        this.jwtVerifier = jwtVerifier;
        this.refreshTokenQueryGateway = refreshTokenQueryGateway;
        this.accessTokenCreator = accessTokenCreator;
        this.refreshTokenPersistenceGateway = refreshTokenPersistenceGateway;
    }

    @Override
    public RefreshTokenReply refresh(RefreshTokenRequest refreshTokenRequest) {
        validateRefreshTokenRequest(refreshTokenRequest);

        final var newTokenPair = generateNewJsonWebTokenPair(refreshTokenRequest);
        persistJsonWebTokenPair(newTokenPair);

        return new RefreshTokenReply(newTokenPair);
    }

    private void validateRefreshTokenRequest(RefreshTokenRequest refreshToken) {
        validateIfRefreshTokenIsValid(refreshToken.tokenPair().refreshToken());
        validateIfAccessTokenBelongsToRefreshToken(refreshToken.tokenPair());
    }

    private void validateIfRefreshTokenIsValid(ApiJsonWebToken refreshToken) {
        try {
            jwtVerifier.verify(refreshToken.value());
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("Invalid refresh token");
        }
    }

    private void validateIfAccessTokenBelongsToRefreshToken(ApiJsonWebTokenPair jsonWebTokenPair) {
        final var receivedJsonWebTokenPair = findJsonWebTokenPairByRefreshToken(jsonWebTokenPair.refreshToken());
        if (!accessTokensMatch(jsonWebTokenPair.accessToken(), receivedJsonWebTokenPair.accessToken())) {
            throw new IllegalArgumentException("Invalid refresh token");
        }
    }

    private static boolean accessTokensMatch(ApiJsonWebToken accessToken, PersistenceJsonWebToken anotherAccessToken) {
        return Objects.equals(accessToken, new ApiJsonWebToken(anotherAccessToken.value()));
    }

    private RefreshTokenQueryReply findJsonWebTokenPairByRefreshToken(ApiJsonWebToken refreshToken) {
        return refreshTokenQueryGateway.findJsonWebTokenPairByRefreshToken(new PersistenceJsonWebToken(refreshToken.value()));
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

    private void persistJsonWebTokenPair(ApiJsonWebTokenPair newTokenPair) {
        refreshTokenPersistenceGateway.persist(toRefreshTokenPersistenceRequest(newTokenPair));
    }

    private static RefreshTokenPersistenceRequest toRefreshTokenPersistenceRequest(ApiJsonWebTokenPair newTokenPair) {
        return new RefreshTokenPersistenceRequest(new PersistenceJsonWebToken(newTokenPair.refreshToken().value()), new PersistenceJsonWebToken(newTokenPair.accessToken().value()));
    }
}
