package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service
class DefaultAccessTokenCreator implements AccessTokenCreator {
    private final Clock clock;

    public DefaultAccessTokenCreator() {
        this(Clock.systemUTC());
    }

    DefaultAccessTokenCreator(Clock clock) {
        this.clock = clock;
    }

    @Override
    public ApiJsonWebToken create(JwtCreateRequest jwtCreateRequest) {
        final var now = Instant.now(clock);
        final var accessToken = JWT.create()
                .withClaim("userId", jwtCreateRequest.userIdentifier().value())
                .withClaim("username", jwtCreateRequest.username().value())
                .withIssuedAt(now)
                .withExpiresAt(now.plus(30, MINUTES))
                .sign(signAlgorithm());
        return new ApiJsonWebToken(accessToken);
    }

    private Algorithm signAlgorithm() {
        return HMAC512("secret".getBytes());
    }
}
