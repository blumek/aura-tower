package com.tower.aura.service.authentication.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tower.aura.api.authentication.model.ApiJsonWebToken;
import com.tower.aura.spi.authentication.jwt.AccessTokenCreator;
import com.tower.aura.spi.authentication.jwt.JwtCreateRequest;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
class DefaultAccessTokenCreator implements AccessTokenCreator {
    private final Algorithm algorithm;
    private final Clock clock;

    DefaultAccessTokenCreator(Algorithm algorithm, Clock clock) {
        this.algorithm = algorithm;
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
                .sign(algorithm);
        return new ApiJsonWebToken(accessToken);
    }
}
