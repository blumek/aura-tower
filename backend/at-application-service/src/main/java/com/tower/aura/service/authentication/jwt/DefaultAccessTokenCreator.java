package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;

@Service
class DefaultAccessTokenCreator implements AccessTokenCreator {
    private final Algorithm algorithm;
    private final Clock clock;
    private final JwtExpirationTimePolicy expirationTimePolicy;

    DefaultAccessTokenCreator(Algorithm algorithm, Clock clock, JwtExpirationTimePolicy expirationTimePolicy) {
        this.algorithm = algorithm;
        this.clock = clock;
        this.expirationTimePolicy = expirationTimePolicy;
    }

    @Override
    public ApiJsonWebToken create(JwtCreateRequest jwtCreateRequest) {
        final var now = ZonedDateTime.now(clock);
        final var accessToken = JWT.create()
                .withClaim("userId", jwtCreateRequest.userIdentifier().value())
                .withClaim("username", jwtCreateRequest.username().value())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plus(expirationTimePolicy.expirationTime()).toInstant())
                .sign(algorithm);
        return new ApiJsonWebToken(accessToken);
    }
}
