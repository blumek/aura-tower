package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.api.authentication.model.ApiJsonWebTokenPair;
import com.tower.aura.spi.authentication.jwt.JwtTokenPairCreator;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;

import static org.springframework.security.core.token.Sha512DigestUtils.shaHex;

@Service
class DefaultJwtTokenPairCreator implements JwtTokenPairCreator {
    private final Algorithm algorithm;
    private final Clock clock;
    private final JwtExpirationTimePolicy expirationTimePolicy;

    DefaultJwtTokenPairCreator(Algorithm algorithm, Clock clock, JwtExpirationTimePolicy expirationTimePolicy) {
        this.algorithm = algorithm;
        this.clock = clock;
        this.expirationTimePolicy = expirationTimePolicy;
    }

    @Override
    public ApiJsonWebTokenPair create(JwtCreateRequest jwtCreateRequest) {
        final var accessToken = createAccessToken(jwtCreateRequest);
        final var refreshToken = createRefreshToken(accessToken);

        return new ApiJsonWebTokenPair(accessToken, refreshToken);
    }

    private ApiJsonWebToken createAccessToken(JwtCreateRequest jwtCreateRequest) {
        final var now = ZonedDateTime.now(clock);
        final var accessToken = JWT.create()
                .withClaim("token_type", "access_token")
                .withClaim("user_id", jwtCreateRequest.userIdentifier().value())
                .withClaim("username", jwtCreateRequest.username().value())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plus(expirationTimePolicy.expirationTime()).toInstant())
                .sign(algorithm);
        return new ApiJsonWebToken(accessToken);
    }

    private ApiJsonWebToken createRefreshToken(ApiJsonWebToken accessToken) {
        final var now = ZonedDateTime.now(clock);
        final var refreshToken = JWT.create()
                .withClaim("token_type", "refresh_token")
                .withClaim("access_token", shaHex(accessToken.value()))
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plus(expirationTimePolicy.expirationTime()).toInstant())
                .sign(algorithm);
        return new ApiJsonWebToken(refreshToken);
    }
}
